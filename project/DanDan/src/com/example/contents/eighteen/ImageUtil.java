package com.example.contents.eighteen;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.dandan.R;

public class ImageUtil {

	
	public static Bitmap getSelectImage(Context context)
	{
		Bitmap bm = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.selected);
		return bm;
	}
	
	/**
	 * @see get all image id (all image is begin with "p_").
	 * @param void
	 * @return
	 */
	public static List<Integer> getImageValues()
	{
		Field[] drawableFields = R.drawable.class.getFields();
		List<Integer> resourceValues = new ArrayList<Integer>();
		for (Field field : drawableFields)
		{
			if (field.getName().indexOf("p_") != -1) {
				try {
					resourceValues.add(field.getInt(R.drawable.class));
				} catch (IllegalArgumentException e) {
					Log.d(TAG, "IlleagalArgumentException");
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					Log.d(TAG, "IllegalAccessException");
					e.printStackTrace();
				}
			}
				
		}
		
		return resourceValues;
	}
	
	/**
	 * @see get ImageId according random function.
	 * @param sourceValue
	 * @param size
	 * @return List contains image Id.
	 */
	
	public static List<Integer> getRandomValues(List<Integer> sourceValue, int size)
	{
		Random random = new Random();
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			try {
				int index = random.nextInt(sourceValue.size());
				Integer image = sourceValue.get(index);
				result.add(image);
			} catch (IndexOutOfBoundsException e) {
				return result;
			}
		}
		return result;
		
	}
	
	/**
	 * @param size get image ID size
	 * @return List save images ID
	 */
	public static List<Integer> getPlayValues(int size)
	{
		if (size % 2 != 0) {
			size += 1;
		}
		
		List<Integer> playImageValues = getRandomValues(mImageValue, size / 2);
		playImageValues.addAll(playImageValues);
		Collections.shuffle(playImageValues);
		return playImageValues;
	}
	
	/**
	 * 
	 * @param context
	 * @param size
	 * @return
	 */
	public static List<PieceImage> getPlayImages(Context context, int size)
	{
		List<Integer> resourceValues = getPlayValues(size);
		List<PieceImage> result = new ArrayList<PieceImage>();
		for (Integer value : resourceValues) {
			Bitmap bm = BitmapFactory.decodeResource(context.getResources(), value);
			PieceImage pieceimage = new PieceImage(bm, value);
			result.add(pieceimage);
		}
		
		return result;
	}
	
	
	
	public static String TAG = "ImageUtil";
	private static List<Integer> mImageValue = getImageValues();
}
