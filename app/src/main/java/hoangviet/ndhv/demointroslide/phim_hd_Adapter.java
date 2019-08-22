package hoangviet.ndhv.demointroslide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class phim_hd_Adapter extends RecyclerView.Adapter<phim_hd_Adapter.PhimViewHolder> {
    private List<phim_hd> phimHdList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public phim_hd_Adapter(List<phim_hd> phimHdList, Context mContext) {
        this.phimHdList = phimHdList;
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public PhimViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.cardview_home,viewGroup,false);
        return new PhimViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhimViewHolder phimViewHolder, int i) {
        phim_hd phim_hd = phimHdList.get(i);
        phimViewHolder.txt_titlte.setText(phim_hd.getTittle());
        phimViewHolder.txt_gia.setText(phim_hd.getGia());
        Picasso.get().load(phim_hd.getHinh()).into(phimViewHolder.imgHinh);
    }

    @Override
    public int getItemCount() {
        return phimHdList.size();
    }

    public class PhimViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgHinh;
        private TextView txt_titlte;
        private TextView txt_gia;


        public PhimViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinh = (ImageView)itemView.findViewById(R.id.img_hinh_home);
            txt_titlte = (TextView)itemView.findViewById(R.id.txt_tenphim);
            txt_gia = (TextView)itemView.findViewById(R.id.txt_gia);

        }
    }
}
