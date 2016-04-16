package com.ninise.computoolsglobaltest.mvp.model.media;


import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.ninise.computoolsglobaltest.mvp.model.entities.CardViewEntity;

import rx.Observable;

public class UserMedia {

    public static Observable<CardViewEntity> getUserMusic(Context context) {
        return Observable.create(subscriber -> {
            final Cursor mCursor = context.getContentResolver().query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    new String[] {
                            MediaStore.Audio.Media.DISPLAY_NAME,
                            String.valueOf(MediaStore.Audio.Media.DATA)}, null, null,
                    "LOWER(" + MediaStore.Audio.Media.TITLE + ") ASC");


            if (mCursor.moveToFirst()) {
                do {
                    subscriber.onNext(new CardViewEntity(mCursor.getString(0), mCursor.getString(1)));
                } while (mCursor.moveToNext());
            }

            mCursor.close();

            subscriber.onCompleted();
        });
    }
}
