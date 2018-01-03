package ca.on.conestogac.kjproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        new GetImageTask((ImageView) findViewById(R.id.imgPop))
                .execute("http://www.onthescent.co.uk/images/dog-check-list-gooddog.jpg");

        }

        private class GetImageTask extends AsyncTask<String, Void, Bitmap> {
            ImageView dogImage;

            public GetImageTask(ImageView dogImage) {
                this.dogImage = dogImage;
            }

            protected Bitmap doInBackground(String... urls) {
                String urldisplay = urls[0];
                Bitmap mIcon11 = null;
                try {
                    InputStream in = new java.net.URL(urldisplay).openStream();
                    mIcon11 = BitmapFactory.decodeStream(in);
                } catch (Exception e) {
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }
                return mIcon11;
            }

            protected void onPostExecute(Bitmap result) {
                dogImage.setImageBitmap(result);
            }
        }
    }
