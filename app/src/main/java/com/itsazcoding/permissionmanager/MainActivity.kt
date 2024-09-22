package com.itsazcoding.permissionmanager

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.itsazcoding.permissionmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IPermissionManager by PermissionManager() {
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initialize(this)

        ViewCompat.setOnApplyWindowInsetsListener(mBinding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        clicks()
    }

    private fun clicks() {
        with(mBinding) {
            askCameraPermission.setOnClickListener {
                requestRuntimePermissions(
                    this@MainActivity,
                    arrayOf(Manifest.permission.CAMERA)
                )

                onPermitted { granted ->
                    if (granted) {
                        Toast.makeText(this@MainActivity, "Permission Granted", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "Permission NOT Granted",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            findCameraPermissionGranted.setOnClickListener {
                if (permissionsGranted(this@MainActivity, Manifest.permission.CAMERA)) {
                    Toast.makeText(
                        this@MainActivity,
                        "Permission Already Granted",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Permission NOT already granted",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            findCameraPermissionPermanentlyDenied.setOnClickListener {
                if (permissionsPermanentlyDenied(this@MainActivity, Manifest.permission.CAMERA)) {
                    Toast.makeText(
                        this@MainActivity,
                        "Permission permanently denied",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Permission NOT permanently denied",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}