package dsa.upc.edu.dsa_project_android;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import dsa.upc.edu.dsa_project_android.Manager.User;
import dsa.upc.edu.listapp.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<User> values;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        //public ImageView icon;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    //----------------------------------------------------------------------------------------------

    public void setData(List<User> myDataset) {
        values = myDataset;
        notifyDataSetChanged();
    }

    //----------------------------------------------------------------------------------------------

    //Añade cancion sin autor
    public void add(int position, User nameUser) {
        values.add(position, nameUser);
        notifyItemInserted(position);
    }

    //----------------------------------------------------------------------------------------------

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    //----------------------------------------------------------------------------------------------

    public MyAdapter() {
        values = new ArrayList<>();
    }

    //----------------------------------------------------------------------------------------------

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<User> myDataset) {
        values = myDataset;
    }

    //----------------------------------------------------------------------------------------------

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //----------------------------------------------------------------------------------------------

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        User c = values.get(position);
        final String name = c.getName();
        holder.txtHeader.setText(name);
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(holder.getAdapterPosition());
            }
        });

        holder.txtFooter.setText("User: " + c.getName());
    }

    //----------------------------------------------------------------------------------------------

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}