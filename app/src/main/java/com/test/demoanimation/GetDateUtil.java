package com.test.demoanimation;

import com.test.demoanimation.mode.ImageAndTextInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/9.
 */

public class GetDateUtil {

    public  static       ArrayList<ImageAndTextInfo>   getData()
    {

        ArrayList<ImageAndTextInfo>  andTextInfos=new ArrayList<>();
        ImageAndTextInfo  andTextInfo=new  ImageAndTextInfo();
        andTextInfo.setImgUrl("http://f.hiphotos.baidu.com/image/pic/item/faf2b2119313b07e97f760d908d7912396dd8c9c.jpg");
        andTextInfo.setContext("很漂亮");
        andTextInfos.add(andTextInfo);

        ImageAndTextInfo  andTextInfo1=new  ImageAndTextInfo();
        andTextInfo1.setImgUrl("http://g.hiphotos.baidu.com/image/pic/item/4b90f603738da977c76ab6fab451f8198718e39e.jpg");
        andTextInfo1.setContext("很好");
        andTextInfos.add(andTextInfo1);

        ImageAndTextInfo  andTextInfo2=new  ImageAndTextInfo();
        andTextInfo2.setImgUrl ("http://e.hiphotos.baidu.com/image/pic/item/902397dda144ad343de8b756d4a20cf430ad858f.jpg");
        andTextInfo2.setContext("么么");
        andTextInfos.add(andTextInfo2);

        ImageAndTextInfo  andTextInfo3=new  ImageAndTextInfo();
        andTextInfo3.setImgUrl("http://a.hiphotos.baidu.com/image/pic/item/a6efce1b9d16fdfa0fbc1ebfb68f8c5495ee7b8b.jpg");
        andTextInfo3.setContext("我喜欢");
        andTextInfos.add(andTextInfo3);

        ImageAndTextInfo  andTextInfo4=new  ImageAndTextInfo();
        andTextInfo4.setImgUrl("http://b.hiphotos.baidu.com/image/pic/item/a71ea8d3fd1f4134e61e0f90211f95cad1c85e36.jpg");
        andTextInfo4.setContext("啦啦");
        andTextInfos.add(andTextInfo4);

        ImageAndTextInfo  andTextInfo5=new  ImageAndTextInfo();
        andTextInfo5.setImgUrl("http://c.hiphotos.baidu.com/image/pic/item/7dd98d1001e939011b9c86d07fec54e737d19645.jpg");
        andTextInfo5.setContext("不错");
        andTextInfos.add(andTextInfo5);

        ImageAndTextInfo  andTextInfo6=new  ImageAndTextInfo();
        andTextInfo6.setImgUrl("http://pica.nipic.com/2007-10-17/20071017111345564_2.jpg");
        andTextInfo6.setContext("66");
        andTextInfos.add(andTextInfo6);

        ImageAndTextInfo  andTextInfo7=new  ImageAndTextInfo();
        andTextInfo7.setImgUrl("http://pic4.nipic.com/20091101/3672704_160309066949_2.jpg");
        andTextInfo7.setContext("赞");
        andTextInfos.add(andTextInfo7);

        ImageAndTextInfo  andTextInfo8=new  ImageAndTextInfo();
        andTextInfo8.setImgUrl("http://pic4.nipic.com/20091203/1295091_123813163959_2.jpg");
        andTextInfo8.setContext("大赞");
        andTextInfos.add(andTextInfo8);

        ImageAndTextInfo  andTextInfo9=new  ImageAndTextInfo();
        andTextInfo9.setImgUrl("http://pic31.nipic.com/20130624/8821914_104949466000_2.jpg");
        andTextInfo9.setContext("推荐");
        andTextInfos.add(andTextInfo9);

        return  andTextInfos;
    }
}
