package com.calvert.aa.core.coreUtil.imageLoader

import android.widget.ImageView
import coil.load
import coil.transform.CircleCropTransformation
import com.calvert.aa.core.R

fun ImageView.loadImageFromUrl(url: String?, isCircle: Boolean) {
    this.load(url) {
        if (isCircle) {
            transformations(CircleCropTransformation())
        }
        placeholder(R.drawable.ic_baseline_loop_24)
        error(R.drawable.ic_baseline_broken_image_24)
        fallback(R.drawable.ic_baseline_broken_image_24)
    }
}