package com.shvedov.uikit

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.widget.TextView
import androidx.annotation.StyleableRes
import androidx.constraintlayout.widget.ConstraintLayout

class TabCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val text by lazy { findViewById<TextView>(R.id.tab_text) }

    init {
        inflate(context, R.layout.tab_custom_view, this)

        attrs?.applyStyleable(context, R.styleable.TabCustomView) {
            text.text = getString(R.styleable.TabCustomView_tabText)
            text.setTextColor(getColor(R.styleable.TabCustomView_tabTextColor, Color.BLACK))
        }
    }
}

inline fun AttributeSet.applyStyleable(context: Context,
                                       @StyleableRes styleableResId: IntArray,
                                       action: TypedArray.() -> Unit) {

    val typedArray = context.obtainStyledAttributes(this, styleableResId)
    typedArray.action()
    typedArray.recycle()
}