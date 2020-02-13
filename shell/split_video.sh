#!/bin/bash
#use script: sh split_video.sh $fileName
FILE=$1
SPLIT_SIZE=65535
echo "file: $FILE"
echo "split size: $SPLIT_SIZE"

FILE_NAME=$(echo "$FILE" | cut -d . -f1)
echo "fileName: $FILE_NAME"

ffmpeg -i "$FILE" -vcodec h264 "$FILE_NAME".mp4
echo "convert $FILE to $FILE_NAME.mp4"

MP4Box -split-size "$SPLIT_SIZE" "$FILE_NAME".mp4

rm -rf $FILE_NAME.mp4

myArray=$(ls $FILE_NAME*.mp4)
echo "file arr: $myArray"
for i in ${myArray[@]}
do
    echo "$i"
    NEW_FILE_NAME=$(echo "$i" | cut -d . -f1)
    echo "new ts file name: $NEW_FILE_NAME"
    CONVERT=$NEW_FILE_NAME'.ts'

    echo "new file name: $CONVERT"
    ffmpeg -i "$i" -vcodec h264 "$CONVERT"

    rm -rf $i
done