package app.sandoval.com.shoppingmovies.ui.moviedetails.reviews;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import app.sandoval.com.shoppingmovies.data.local.model.Review;
import app.sandoval.com.shoppingmovies.databinding.ItemReviewBinding;

public class ReviewsViewHolder extends RecyclerView.ViewHolder {

    private ItemReviewBinding binding;

    public ReviewsViewHolder(@NonNull ItemReviewBinding binding) {
        super(binding.getRoot());

        this.binding = binding;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.frame.setClipToOutline(false);
        }
    }

    public void bindTo(final Review review) {
        String userName = review.getAuthor();

        // review user image
        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color = generator.getRandomColor();
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(userName.substring(0, 1).toUpperCase(), color);
        binding.imageAuthor.setImageDrawable(drawable);

        // review's author
        binding.textAuthor.setText(userName);

        // review's content
        binding.textContent.setText(review.getContent());

        binding.executePendingBindings();
    }

    public static ReviewsViewHolder create(ViewGroup parent) {
        // Inflate
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Create the binding
        ItemReviewBinding binding =
                ItemReviewBinding.inflate(layoutInflater, parent, false);
        return new ReviewsViewHolder(binding);
    }
}
