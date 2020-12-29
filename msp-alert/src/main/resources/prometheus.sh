#!/bin/bash
# 启动应用
start(){
    echo "==================启动prometheus=================="
    nohup ./prometheus & > nohup.out
}
# 停止应用
stop(){
    echo "==================停止prometheus=================="

    pid=$(ps x | grep './prometheus' | grep -v grep | awk '{print $1}')
    if [ ${pid} ];then
        echo "Stop Process"
        kill -15 $pid
    else
        echo "Stop SUCCESS"
    fi

    sleep 5

    pid=$(ps x | grep './prometheus' | grep -v grep | awk '{print $1}')
    if [ ${pid} ];then
        echo "Stop Process"
        kill -15 $pid
    else
        echo "Stop SUCCESS"
    fi

    sleep 5

    pid=$(ps x | grep './prometheus' | grep -v grep | awk '{print $1}')
    if [ ${pid} ];then
        echo "Stop Process"
        kill -15 $pid
    else
        echo "Stop SUCCESS"
    fi
}
# restart
restart(){
	stop
	start
}
# reload
reload(){
    pid=$(ps x | grep './prometheus' | grep -v grep | awk '{print $1}')
    if [ ${pid} ];then
        echo "更新配置数据"
        kill -Hup $pid
    else
        echo "更新成功"
    fi
}
#使用说明，用来提示输入参数
usage() {
    echo "Usage: sh 执行脚本.sh [start|stop|restart|reload]"
    exit 1
}
#
case "$1" in
	"start")
	start
	;;
	"stop")
	stop
	;;
	"restart")
	restart
	;;
	"")
	reload
	;;
	*)
	usage
	;;
esac