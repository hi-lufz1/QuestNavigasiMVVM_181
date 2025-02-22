package com.example.arsitekturmvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arsitekturmvvm.model.DataMahasiswa
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun DetailMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
    onBackClicked: () ->Unit

    ) {
    val listDataMhs = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("NIM", uiStateMahasiswa.nim),
        Pair("Email", uiStateMahasiswa.email),
        Pair("Alamat", uiStateMahasiswa.alamat),
        Pair("Nomor HP", uiStateMahasiswa.noHp)

    )
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        listDataMhs.forEach { item ->
            CardSection(judulParam = item.first, isiParam = item.second)
        }
        Button(
            onClick = onBackClicked ,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Kembali")
        }
    }
}

@Composable
fun CardSection(judulParam: String, isiParam: String) {
    Column(modifier = Modifier.padding(15.dp), horizontalAlignment = Alignment.Start) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = judulParam, fontSize = 20.sp, modifier = Modifier.weight(0.9f))
            Text(text = " : ", fontSize = 20.sp, modifier = Modifier.weight(0.2f))
            Text(text = isiParam, fontSize = 20.sp, modifier = Modifier.weight(1.4f))
        }

    }
}