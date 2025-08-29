package com.example.qrgenerator.presentation.screens.generator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.style.TextAlign
import com.example.qrgenerator.utils.helpers.QrHelper


@Composable
fun QrScreen(
    modifier: Modifier = Modifier,
    viewModel: QrViewModel = hiltViewModel()
) {
    var inputUrl by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.Center),
            contentAlignment = Alignment.Center
        ) {
            when (uiState) {
                is QrUIState.Loading -> CircularProgressIndicator()
                is QrUIState.Success -> {
                    val successState = uiState as QrUIState.Success
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            bitmap = successState.bitmap,
                            contentDescription = "QR Code",
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Current Redirect URL: ${successState.qr.redirectUrl}")
                    }
                }
                is QrUIState.Error -> {
                    Text(
                        text = (uiState as QrUIState.Error).message,
                        color = Color.Red,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp)
                .padding(bottom = 124.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                value = inputUrl,
                onValueChange = { inputUrl = it },
                label = { Text("Enter new redirect URL") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { viewModel.updateRedirectUrl(inputUrl) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Update Redirect URL")
            }
        }
    }
}