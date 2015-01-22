package lv.bizapps.starbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class StarButton extends ImageView {
	protected boolean starButtonActiveState = false;

	protected StarButton starButton;
	protected OnStateChangeListener stateChangeListener;

	public StarButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		if(!starButtonActiveState) {
			setImageDrawable(getResources().getDrawable(R.drawable.grey_star_large));
		}
		else setImageDrawable(getResources().getDrawable(R.drawable.yellow_star_large));

		starButton = this;

		this.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(!starButtonActiveState) {
					setImageDrawable(getResources().getDrawable(R.drawable.yellow_star_large));
				}
				else {
					setImageDrawable(getResources().getDrawable(R.drawable.grey_star_large));
				}

				starButtonActiveState = !starButtonActiveState;

				if(stateChangeListener != null && stateChangeListener instanceof OnStateChangeListener) {
					stateChangeListener.onStateChanged(starButton, starButtonActiveState);
				}
			}
		});
	}

	public StarButton(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public StarButton(Context context) {
		super(context);
	}

	public void setOnStateChangeListener(OnStateChangeListener l) {
		this.stateChangeListener = l;
	}

	public static interface OnStateChangeListener {
		public void onStateChanged(StarButton button, boolean isActiveState);
	}
}