package com.example.whatshouldiwear;
/** code for customer recycler view item adapter
 *
 * @author Peter Saunders
 * @version 1.0
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private ArrayList<Item> outfitItems;
    private Context context;

    /**
     * constructor for recycler adapter
     * @param context activity in which it is created
     * @param outfitItems list of items to inflate
     */
    public ItemAdapter(Context context, ArrayList<Item> outfitItems) {
        this.context = context;
        this.outfitItems = outfitItems;
    }

    /**
     * action listener to conform to recycler adapter
     * @param parent parent view group the viewholder sits in
     * @param viewType type of view, ignored..
     * @return view holder created
     */
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.recycler_list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /**
     * binds items to the created holder
     * @param holder previously created view holder
     * @param position what position in the list the item should sit at
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Item model = outfitItems.get(position);
        holder.recycler_image.setImageResource(model.getIcon());
        holder.recycler_title.setText(model.getTitle());
        holder.recycler_detail.setText(this.context.getText(R.string.recycler_protection) + " " + model.getDetail());
        holder.recycler_check.setChecked(model.getCheck());
    }

    /**
     * simple item counter
     * @return item count of recycler adapter as int
     */
    @Override
    public int getItemCount() {
        return outfitItems.size();
    }

    /**
     * custom view holder to store recycler information
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView recycler_image;
        private TextView recycler_detail, recycler_title;
        private CheckBox recycler_check;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recycler_image = itemView.findViewById(R.id.recycler_image);
            recycler_title = itemView.findViewById(R.id.recycler_title);
            recycler_detail = itemView.findViewById(R.id.recycler_detail);
            recycler_check = itemView.findViewById(R.id.recycler_check);
        }
    }
}
