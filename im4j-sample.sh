#!/bin/sh

#******************************************************************************#
#*     システム名      ：イメージマジックサンプル                             *#
#*     ＳｈｅｌｌＩＤ  ：im4j-sample.sh                                       *#
#*                                                                            *#
#*     機能            ：イメージマジック                                     *#
#*                        ・画像切抜                                          *#
#*                        ・画像合成                                          *#
#*                        ・画像文字                                          *#
#*                        ・フォトカード                                      *#
#*                                                                            *#
#*                                                                            *#
#*     初版　　作成者　：COMSTER)Yamaguchi         作成日：    2015/12/01     *#
#******************************************************************************#
#*     第 1回　修正者　：                           修正日：                  *#
#*             修正内容：                                                     *#
#******************************************************************************#

#cron実行用　日本語設定
export LANG=ja_JP.UTF8

# 変数設定
BASE_PATH=/data/apl/product/shell/zbpk/im4j-test

# スクリプトのパス
SCRIPT_PATH=${BASE_PATH}/bin

# ライブラリのパス
LIB_PATH=${BASE_PATH}/lib/*

# JAVA
JAVA=/opt/java/bin/java

# Java Class Path
CLASS_PATH=${SCRIPT_PATH}/:${LIB_PATH}

# Java Application Name
APP_NAME1=jp.co.comster.im4j.sample.ImageCutterSample
APP_NAME2=jp.co.comster.im4j.sample.MixImageSample
APP_NAME3=jp.co.comster.im4j.sample.StringImageSample
APP_NAME4=jp.co.comster.im4j.sample.PhoteCardSample

# バッチ実行
${JAVA} -Xms128m -Xmx256m -classpath ${CLASS_PATH} ${APP_NAME1} $@
${JAVA} -Xms128m -Xmx256m -classpath ${CLASS_PATH} ${APP_NAME2} $@
${JAVA} -Xms128m -Xmx256m -classpath ${CLASS_PATH} ${APP_NAME3} $@
${JAVA} -Xms128m -Xmx256m -classpath ${CLASS_PATH} ${APP_NAME4} $@
