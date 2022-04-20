package com.amirhusseinsoori.todolist_780_compose.ui.screen.intro

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.amirhusseinsoori.todolist_780_compose.ui.navigation.ScreenRoute
import kotlinx.coroutines.delay
import com.amirhusseinsoori.todolist_780_compose.R
import com.amirhusseinsoori.todolist_780_compose.ui.screen.utilFont
import com.amirhusseinsoori.todolist_780_compose.ui.theme.black
import com.amirhusseinsoori.todolist_780_compose.ui.theme.white


@Composable
fun Intro(navController: NavController) {
    val scale = remember { Animatable(0f) }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate(ScreenRoute.Todo.route) {
            popUpTo(ScreenRoute.Intro.route) { inclusive = true }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Loader(R.raw.todo_into)
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = stringResource(id = R.string.intro), color = black, fontFamily = utilFont,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )

    }

}

@Composable
fun Loader(anim: Int) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(anim))
    val progress by animateLottieCompositionAsState(composition)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition,
            progress,
        )
    }
}