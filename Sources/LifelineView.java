package pm12016g3.tln.univ.fr.vot.utilities.views.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import org.androidannotations.annotations.EView;

import pm12016g3.tln.univ.fr.vot.R;

/**
 * Project android.
 * Package pm12016g3.tln.univ.fr.vot.utilities.views.custom.
 * File LifelineView.java.
 * Created by Ysee on 19/05/2017 - 13:21.
 * www.yseemonnier.com
 * https://github.com/YMonnier
 */

@EView
public class LifelineView extends View {
    /**
     * Number of steps.
     */
    private int steps;

    /**
     * Selection rank
     */
    private int selected;

    /**
     * Step radius.
     */
    private int stepRadius;

    /**
     * Default Step color.
     */
    private int stepDefaultColor;

    /**
     * Line color.
     */
    private int lineColor;

    /**
     * Step color when selected.
     */
    private int stepSelectedColor;

    /**
     * Thickness line.
     */
    private int thickness;

    private Paint stepDefaultPaint;
    private Paint stepSelectedPaint;
    private Paint linePaint;

    public LifelineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.LifelineView,
                0, 0);

        try {
            steps = a.getInt(R.styleable.LifelineView_steps, 1);
            thickness = a.getInt(R.styleable.LifelineView_lineThickness, 1);
            selected = a.getInt(R.styleable.LifelineView_selected, 0);
            stepRadius = a.getDimensionPixelSize(R.styleable.LifelineView_stepRadius, 20);
            stepDefaultColor = a.getColor(R.styleable.LifelineView_stepDefaultColor, Color.GRAY);
            stepSelectedColor = a.getColor(R.styleable.LifelineView_stepSelectedColor, Color.RED);
            lineColor = a.getColor(R.styleable.LifelineView_lineColor, Color.BLACK);
        } finally {
            a.recycle();
        }
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float middle = (getHeight() / 2) - thickness;
        canvas.drawLine(0, middle, getWidth(), middle, linePaint);
        int stepC = getWidth() / (steps + 1);
        int circleX = 0;
        for (int i = 0; i < steps; i++) {
            circleX += stepC;
            if ((i + 1) <= selected)
                canvas.drawCircle(circleX,
                        middle,
                        stepRadius,
                        stepSelectedPaint);
            else
                canvas.drawCircle(circleX,
                        middle,
                        stepRadius,
                        stepDefaultPaint);
        }
    }

    /**
     * Initialization of the graphic parameters.
     */
    private void init() {
        stepDefaultPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        stepDefaultPaint.setColor(stepDefaultColor);

        stepSelectedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        stepSelectedPaint.setColor(stepSelectedColor);

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStrokeWidth(thickness);
        linePaint.setColor(lineColor);
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
        invalidate();
        requestLayout();
    }

    public int getStepDefaultColor() {
        return stepDefaultColor;
    }

    public void setStepDefaultColor(int stepDefaultColor) {
        this.stepDefaultColor = stepDefaultColor;
        invalidate();
        requestLayout();
    }

    public int getStepSelectedColor() {
        return stepSelectedColor;
    }

    public void setStepSelectedColor(int stepSelectedColor) {
        this.stepSelectedColor = stepSelectedColor;
        invalidate();
        requestLayout();
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
        invalidate();
        requestLayout();
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
        invalidate();
        requestLayout();
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
        invalidate();
        requestLayout();
    }

    public int getStepRadius() {
        return stepRadius;
    }

    public void setStepRadius(int stepRadius) {
        this.stepRadius = stepRadius;
        invalidate();
        requestLayout();
    }
}
