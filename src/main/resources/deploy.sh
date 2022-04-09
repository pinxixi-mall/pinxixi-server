# 进入备份目录
cd backup/
# 备份数量最大为3，超过3个将删除最旧的
ls -lt|awk 'NR>3{print $NF}'|xargs rm -rf

DATE=$(date +%Y%m%d%H%M)
# 项目基础路径
BASE_PATH=/www/wwwroot/pinxixi_server
# jenkins 打包后上传 jar 包到该目录下
SOURCE_PATH=$BASE_PATH/build
# 服务名称(jar 包名称)
SERVER_NAME=pinxixi-server-0.0.1-SNAPSHOT
# 环境
PROFILES_ACTIVE=prod

# 备份
function backup() {
    # 生成backup目录
    if [ ! -d $BASE_PATH/backup ];then
       mkdir -p $BASE_PATH/backup
    fi
    # 如果不存在，跳过备份
    if [ ! -f "$BASE_PATH/$SERVER_NAME.jar" ]; then
        echo "[backup] $BASE_PATH/$SERVER_NAME.jar 不存在，跳过备份"
    # 如果存在，则备份到 backup 目录下
    else
        echo "[backup] 开始备份 $SERVER_NAME ..."
        cp $BASE_PATH/$SERVER_NAME.jar $BASE_PATH/backup/$SERVER_NAME-$DATE.jar
        echo "[backup] 备份 $SERVER_NAME 完成"
    fi
}

# 替换旧jar包
function transfer() {
    # 删除原 jar 包
    if [ ! -f "$BASE_PATH/$SERVER_NAME.jar" ]; then
        echo "[transfer] $BASE_PATH/$SERVER_NAME.jar 不存在，跳过删除"
    else
        echo "[transfer] 移除 $BASE_PATH/$SERVER_NAME.jar 完成"
        rm $BASE_PATH/$SERVER_NAME.jar
    fi
    # 复制新 jar 包到项目路径
    echo "[transfer] 从 $SOURCE_PATH 中获取 $SERVER_NAME.jar 并迁移至 $BASE_PATH ...."
    cp $SOURCE_PATH/$SERVER_NAME.jar $BASE_PATH

    echo "[transfer] 转移 $SERVER_NAME.jar 完成"
}

# 停止服务
function stop() {
    ps -ef | grep $SERVER_NAME | grep -v grep | awk '{print $2}' | xargs kill -9
}

# 启动服务
function start() {
    echo "[start] 开始启动 $BASE_PATH/$SERVER_NAME"
    nohup java -jar $BASE_PATH/$SERVER_NAME.jar -Djava.security.egd=file:/dev/./urandom --spring.profiles.active=$PROFILES_ACTIVE > ./run.log  &

    if [ $? = 0 ];then
            sleep 30
            tail -n 50 ./run.log
    fi
    echo "[start] $BASE_PATH/$SERVER_NAME 启动完成"
}

# 发布
function deploy() {
    cd $BASE_PATH
    backup
    transfer
    stop
    start
}

deploy
