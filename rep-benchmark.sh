#!/bin/bash

#组实验配置文件名,文件中一行对应一次实验的一个变化参数,该文件必须在项目根目录下
FILENAME=routine

if [ -z "${BENCHMARK_HOME}" ]; then
  export BENCHMARK_HOME="$(cd "`dirname "$0"`"/.; pwd)"
fi

cat $BENCHMARK_HOME/$FILENAME | while read LINE
do
  CHANGE_PARAMETER=$(echo $LINE | cut -d = -f 1)
  #CHANGE_LINE=$(grep -n  $CHANGE_PARAMETER $BENCHMARK_HOME/conf/config.properties | cut -d : -f 1)
  #sed -i "${CHANGE_LINE}s/^.*$/${LINE}/" $BENCHMARK_HOME/conf/config.properties
  if [ -n "$LINE" ]; then
    sed -i "s/^${CHANGE_PARAMETER}.*$/${LINE}/g" $BENCHMARK_HOME/conf/config.properties
    #grep $CHANGE_PARAMETER  $BENCHMARK_HOME/conf/config.properties
    sh $BENCHMARK_HOME/cli-benchmark.sh
  fi
done








#for i in {1..5}
#do
#  sh cli-benchmark.sh
#done

