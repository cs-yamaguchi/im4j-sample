package jp.co.comster.im4j.sample;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

public class ImageCutterSample {


    public static void main(String[] args) throws Exception {

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

    	String basePath = System.getProperty("user.dir");
    	String inimg = basePath + "/img/icon_maitama.jpg";
    	String outimg = basePath + "/img/icon_maitama_out.jpg";

        File src = new File(inimg);
        File dest = new File(outimg);

        ConvertCmd cmd = new ConvertCmd();
//        cmd.setSearchPath("C:\\usr\\bin\\ImageMagick-6.9.2-7-portable-Q16-x86");
      cmd.setSearchPath("/opt/st_benesse_ne_jp/ImageMagick/bin/");


        IMOperation op = new IMOperation();
        op.addImage(src.getAbsolutePath());
//        op.resize(width, height, '^');
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
        op.crop(300, 500, 200, 300);
        op.addImage(dest.getAbsolutePath());
        System.out.println(op.toString());

        Date date = new Date();
        System.out.println("Start Time = " + sdf.format(date));
        cmd.run(op);
        System.out.println("End Time = " + sdf.format(new Date()) + "[" + (new Date().getTime() - date.getTime()) + "]" );
    }

}
