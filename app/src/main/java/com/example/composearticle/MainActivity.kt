package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TutorialPage(
                        stringResource(R.string.tutorial_title),
                        stringResource(R.string.tutorial_body),
                        stringResource(R.string.tutorial_body_two)
                    )
                }
            }
        }
    }
}

@Composable
fun TutorialText(title: String, body: String, bodyOne: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)

        )
        Text(
            text = body,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp,0.dp)
                .fillMaxWidth()
        )
        Text(
            text = bodyOne,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp,16.dp)
                .fillMaxWidth()
        )
    }
}
@Composable
fun TutorialPage(title: String, body: String, bodyOne: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        TutorialText(
            title = title,
            body = body,
            bodyOne = bodyOne,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

// Preview allows live visualization of UI changes without installing the app on a device

@Preview(showBackground = true)
@Composable
fun TutorialPreview() {
    ComposeArticleTheme {
        TutorialPage(
            title = "Jetpack Compose Tutorial",
            body = "Jetpack Compose is Android’s modern toolkit...",
            bodyOne = "In this tutorial you learned..."
        )
    }
}

// Recommended development practices
/*
1. Use string resources instead of hardcoded text for better maintainability and localization.
2. Break UI and logic into smaller, reusable composable functions.
3. Refer to official documentation regularly to deepen understanding of concepts.
*/
