package com.example.arsitekturmvvm

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arsitekturmvvm.model.DataJenisKelamin
import com.example.arsitekturmvvm.ui.view.DetailMahasiswaView
import com.example.arsitekturmvvm.ui.view.MainScreen
import com.example.arsitekturmvvm.ui.viewmodel.MahasiswaViewModel

enum class Halaman {
    Formulir,
    Detail,
}

@Composable
fun PengelolaHalaman(
    navController: NavHostController =  rememberNavController(),
    viewModel: MahasiswaViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Scaffold { isipadding ->
        val stateUI by viewModel.uiState.collectAsState()

        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navController, startDestination = Halaman.Formulir.name)
        {
            composable(route = Halaman.Formulir.name) {
                val konteks = LocalContext.current
                MainScreen(
                    listJK = DataJenisKelamin.listJK.map { id ->
                        konteks.resources.getString(
                            id
                        )
                    },
                    onSubmitClicked = {
                        viewModel.saveDataMahasiswa(it)
                        navController.navigate(Halaman.Detail.name)

                    }
                )
            }
            composable(route = Halaman.Detail.name){
                DetailMahasiswaView(
                  uiStateMahasiswa =  stateUI,
                    onBackClicked = {navController.popBackStack()}
                )
            }
        }
    }
}