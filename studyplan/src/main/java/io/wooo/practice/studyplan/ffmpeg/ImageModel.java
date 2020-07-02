package io.wooo.practice.studyplan.ffmpeg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 图片对象
 *
 * @author wb-wsp312690
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageModel {

    /**
     * person左上X轴坐标
     */
    private int leftTopX;

    /**
     * person左上Y轴坐标
     */
    private int leftTopY;

    /**
     * person右下X轴坐标
     */
    private int rightBtmX;

    /**
     * person右下Y轴坐标
     */
    private int rightBtmY;

    /**
     * 图片url路径
     */
    private String imgUrl;

}
