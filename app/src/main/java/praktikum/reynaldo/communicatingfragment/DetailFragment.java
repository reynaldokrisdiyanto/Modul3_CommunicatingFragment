package praktikum.reynaldo.communicatingfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    //Instansiasi
    private MovieModel movieModel;
    private TextView tvJudul, tvGenre, tvRating, tvSinopsis, tvContentSinopsis;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        if (getArguments() != null)
        {
            //Untuk menangkap data berupa parcelable
            movieModel = getArguments().getParcelable(MainActivity.class.getSimpleName());
        }

        if (movieModel != null)
        {
            initializeViews(view);
            tvJudul.setText(movieModel.getJudul());
            tvRating.setText(movieModel.getRatingScore());
            tvGenre.setText(movieModel.getGenre());
            imageView.setImageResource(movieModel.getPoster());
            tvSinopsis.setText(movieModel.getSinopsis());
        }

        return view;
    }

    private void initializeViews(View view) {
        tvJudul = (TextView) view.findViewById(R.id.tvJudul);
        tvGenre = (TextView) view.findViewById(R.id.tvGenre);
        tvRating = (TextView) view.findViewById(R.id.tvRating);
        tvSinopsis = (TextView) view.findViewById(R.id.tvSinopsis);
        tvContentSinopsis = (TextView) view.findViewById(R.id.tvContentSinopsis);
        imageView = (ImageView) view.findViewById(R.id.imageView);
    }
}