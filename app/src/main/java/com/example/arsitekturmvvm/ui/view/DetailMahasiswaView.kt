package com.example.arsitekturmvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arsitekturmvvm.model.DataMahasiswa

@Composable
fun DetailMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
    onSubmitClicked: () ->Unit

    ) {
    val listDataMhs = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("Alamat", uiStateMahasiswa.alamat),
    )
    Column() {
        listDataMhs.forEach { item ->
            CardSection(judulParam = item.first, isiParam = item.second)
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