package app.sandoval.com.shoppingmovies.ui;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import app.sandoval.com.shoppingmovies.R;
import app.sandoval.com.shoppingmovies.utils.Constants;
import app.sandoval.com.shoppingmovies.utils.GlideApp;

public class BindingAdapters {

    @BindingAdapter({"imageUrl", "isBackdrop"})
    public static void bindImage(ImageView imageView, String imagePath, boolean isBackdrop) {
        String baseUrl;
        if (isBackdrop) {
            baseUrl = Constants.BACKDROP_URL;
        } else {
            baseUrl = Constants.IMAGE_URL;
        }

        GlideApp.with(imageView.getContext())
                .load(baseUrl + imagePath)
                .placeholder(R.color.md_grey_200)
                .into(imageView);
    }


    @BindingAdapter("visibleGone")
    public static void showHide(View view, Boolean show) {
        if (show) view.setVisibility(View.VISIBLE);
        else view.setVisibility(View.GONE);
    }

}