package com.example.app_firebase.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.app_firebase.R
import java.time.format.TextStyle

// Defina a fonte personalizada
val NerkoOneFontFamily = FontFamily(
    Font(R.font.nerko_one) // Certifique-se de que o nome do arquivo é correto
)

// Crie uma tipografia personalizada
@RequiresApi(Build.VERSION_CODES.O)
val AppTypography = Typography(
    // Definindo a tipografia padrão, pode ser ajustada conforme necessário
    bodyLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = NerkoOneFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    titleLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = NerkoOneFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    // Adicione outras configurações conforme necessário, por exemplo:
    // headlineLarge, bodyMedium, etc.
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun App_FirebaseTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = AppTypography, // Aplique a tipografia personalizada
        content = content
    )
}
