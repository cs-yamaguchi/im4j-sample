package jp.co.comster.im4j.sample;

import java.io.File;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

public class MixImageSample {


    public static void main(String[] args) throws Exception {

    	String basePath = System.getProperty("user.dir");
    	String inimg = basePath + "/img/icon_maitama.jpg";
    	String miximg = basePath + "/img/flower-back0557.png";
    	String outimg = basePath + "/img/mix-out.jpg";

        File src = new File(inimg);
        File src2 = new File(miximg);
        File dest = new File(outimg);

        ConvertCmd cmd = new ConvertCmd();
//      cmd.setSearchPath("C:\\usr\\bin\\ImageMagick-6.9.2-7-portable-Q16-x86");
        cmd.setSearchPath("/opt/st_benesse_ne_jp/ImageMagick/bin/");

        IMOperation op = new IMOperation();
        op.addImage(src.getAbsolutePath());
        op.addImage(src2.getAbsolutePath());
//        op.resize(1024, 1024, '^');
        op.resize(1024, 1024, '!');
        op.gravity("northwest");

        //northwest	左上
        //north		上
        //northeast	右上
        //west		左
        //east		右
        //southwest	左下
        //south		下
        //southeast	右下
        //center	真ん中
        //      横幅 縦幅 開始横 開始縦
        op.composite();
        op.addImage(dest.getAbsolutePath());
        System.out.println(op.toString());

        cmd.run(op);
    }

}
