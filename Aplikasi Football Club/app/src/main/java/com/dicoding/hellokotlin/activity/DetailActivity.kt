package com.dicoding.hellokotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*


class DetailActivity : AppCompatActivity() {

    companion object {
        const val aName = "tittle"
        const val aImage = "image"
        const val aInfo = "info"
    }

    private var mNama: String = ""
    private var mLogo: Int = 0
    private var mInfo: String = ""

    private lateinit var namaClub: TextView
    private lateinit var logoClub: ImageView
    private lateinit var infoClub: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)

            logoClub = imageView().
            lparams(width = wrapContent, height = dip(100)) {
                gravity = Gravity.CENTER
                padding = dip(30)
            }

            namaClub = textView().
            lparams(width = wrapContent) {
                gravity = Gravity.CENTER
                topMargin = dip(10)
            }

            infoClub = textView().
            lparams(width = wrapContent) {
                topMargin = dip(5)
                leftMargin = dip(20)
                rightMargin = dip(20)
            }
        }

        mLogo = intent.getIntExtra(aImage, 0)
        mNama = intent.getStringExtra(aName)
        mInfo = intent.getStringExtra(aInfo)

        Picasso.get()
                .load(mLogo)
                .into(logoClub)
        namaClub.text = mNama
        infoClub.text = mInfo
    }
}