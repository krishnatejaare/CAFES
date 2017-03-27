package com.example.arekr.lab3;

/**
 * Created by arekr on 24/07/2016.
 */


        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.List;
        import java.util.StringTokenizer;

public class CafesAdapter extends RecyclerView.Adapter<CafesAdapter.MyViewHolder> {

    private List<Record> cafesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, vicinity,rating;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            vicinity = (TextView) view.findViewById(R.id.vicinity);
            rating= (TextView) view.findViewById(R.id.rating);
        }
    }


    public CafesAdapter(List<Record> cafesList) {
        this.cafesList = cafesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cafe_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Record movie = cafesList.get(position);
        holder.title.setText(String.valueOf(movie.getPlaceName()));
        holder.vicinity.setText(String.valueOf(movie.getVicinity()));

        holder.rating.setText(String.valueOf((Double) movie.getRating()));
    }

    @Override
    public int getItemCount() {
        System.out.println("In the cafes adapter" + cafesList.size());
        return this.cafesList.size();
    }


}
