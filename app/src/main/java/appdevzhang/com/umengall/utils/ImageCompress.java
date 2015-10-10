package appdevzhang.com.umengall.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 图片压缩工具类
 * 
 * @author Administrator
 * 
 */
public class ImageCompress {

	public static final String CONTENT = "content";
	public static final String FILE = "file";

	private static class ImageCompressHolder {
		public static ImageCompress INSTANCE = new ImageCompress() ;
	}
	
	public static ImageCompress getInstance() {
		return ImageCompressHolder.INSTANCE ;
	}
	
	/**
	 * 图片压缩参数
	 * 
	 * @author Administrator
	 * 
	 */
	public static class CompressOptions {
		public static final int DEFAULT_WIDTH = 400;
		public static final int DEFAULT_HEIGHT = 800;

		public int maxWidth = DEFAULT_WIDTH;
		public int maxHeight = DEFAULT_HEIGHT;
		/**
		 * 压缩后图片保存的文件
		 */
		public File destFile;
		/**
		 * 图片压缩格式,默认为jpg格式
		 */
		public CompressFormat imgFormat = CompressFormat.JPEG;

		/**
		 * 图片压缩比例 默认为30
		 */
		public int quality = 30;

		public Uri uri;
		
		public String filepath ;
		
		public int id ; 
	}

	private Bitmap compressFromUri(Context context,
			CompressOptions compressOptions) {

		// uri指向的文件路径
//		String filePath = compressOptions.filepath;
//		String filePath = getFilePath(context, compressOptions.uri);
		
//		if (null == filePath) {
//			return null;
//		}
		
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;

		Bitmap temp = BitmapFactory.decodeResource(context.getResources(), 
				compressOptions.id, options) ;
		
//		System.out.println("**********************************");		
//		System.out.println("Width:" + temp.getWidth() + ", Height:" + temp.getWidth());
//		System.out.println("**********************************");
//		Bitmap temp = BitmapFactory.decodeFile(filePath, options);

		int actualWidth = options.outWidth;
		int actualHeight = options.outHeight;

		int desiredWidth = getResizedDimension(compressOptions.maxWidth,
				compressOptions.maxHeight, actualWidth, actualHeight);
		int desiredHeight = getResizedDimension(compressOptions.maxHeight,
				compressOptions.maxWidth, actualHeight, actualWidth);

		options.inJustDecodeBounds = false;
		options.inSampleSize = findBestSampleSize(actualWidth, actualHeight,
				desiredWidth, desiredHeight);

		Bitmap bitmap = null;

		Bitmap destBitmap = BitmapFactory.decodeResource(context.getResources(), 
				compressOptions.id, options) ;
		// If necessary, scale down to the maximal acceptable size.
		if (destBitmap.getWidth() > desiredWidth
				|| destBitmap.getHeight() > desiredHeight) {
			bitmap = Bitmap.createScaledBitmap(destBitmap, desiredWidth,
					desiredHeight, true);
			destBitmap.recycle();
		} else {
			bitmap = destBitmap;
		}

		// compress file if need
		if (null != compressOptions.destFile) {
			compressFile(compressOptions, bitmap);
		}

		return bitmap;
	}

	/**
	 * compress file from bitmap with compressOptions
	 * 
	 * @param compressOptions
	 * @param bitmap
	 */
	private void compressFile(CompressOptions compressOptions, Bitmap bitmap) {
		OutputStream stream = null;
		try {
			stream = new FileOutputStream(compressOptions.destFile);
		} catch (FileNotFoundException e) {
			Log.e("ImageCompress", e.getMessage());
		}

		bitmap.compress(compressOptions.imgFormat, compressOptions.quality,
				stream);
	}

	private static int findBestSampleSize(int actualWidth, int actualHeight,
			int desiredWidth, int desiredHeight) {
		double wr = (double) actualWidth / desiredWidth;
		double hr = (double) actualHeight / desiredHeight;
		double ratio = Math.min(wr, hr);
		float n = 1.0f;
		while ((n * 2) <= ratio) {
			n *= 2;
		}

		return (int) n;
	}

	private static int getResizedDimension(int maxPrimary, int maxSecondary,
			int actualPrimary, int actualSecondary) {
		// If no dominant value at all, just return the actual.
		if (maxPrimary == 0 && maxSecondary == 0) {
			return actualPrimary;
		}

		// If primary is unspecified, scale primary to match secondary's scaling
		// ratio.
		if (maxPrimary == 0) {
			double ratio = (double) maxSecondary / (double) actualSecondary;
			return (int) (actualPrimary * ratio);
		}

		if (maxSecondary == 0) {
			return maxPrimary;
		}

		double ratio = (double) actualSecondary / (double) actualPrimary;
		int resized = maxPrimary;
		if (resized * ratio > maxSecondary) {
			resized = (int) (maxSecondary / ratio);
		}
		return resized;
	}

	public Drawable getCompressFromId(Context context, int id, int w, int h) {
		CompressOptions compressOptions = new CompressOptions() ;
		compressOptions.id = id ;
		compressOptions.maxHeight = h ;
		compressOptions.maxWidth = w ;
		Bitmap bitmap = compressFromUri(context, compressOptions) ;
		System.out.println("**************End********************");		
		System.out.println("Width:" + bitmap.getWidth() + ", Height:" + bitmap.getHeight());
		System.out.println("Size:" + bitmap.getByteCount());
		System.out.println("**********************************");
		return convertBitmap2Drawable(bitmap) ;
	}
	
	public Drawable convertBitmap2Drawable(Bitmap bitmap) {
        BitmapDrawable bd = new BitmapDrawable(bitmap);
        // 因为BtimapDrawable是Drawable的子类，最终直接使用bd对象即可。
        return bd;
	}

}
