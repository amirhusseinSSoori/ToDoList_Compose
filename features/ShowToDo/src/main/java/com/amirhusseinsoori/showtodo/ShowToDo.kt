package com.amirhusseinsoori.showtodo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.amirhusseinsoori.showtodo.util.red


@Composable
fun ShowToDoScreen(showToDoViewModel: ShowToDoViewModel = hiltViewModel()) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        shape = RoundedCornerShape(50.dp),
        elevation = 40.dp
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (textTitle, textDes, textData) = createRefs()
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .constrainAs(textTitle) {
                        top.linkTo(parent.top, margin = 40.dp)
                        end.linkTo(parent.end, margin = 10.dp)
                        start.linkTo(parent.start, margin = 10.dp)
                    },
                text = showToDoViewModel.todoModelState.title ?: "",
                textAlign = TextAlign.Center,
                color = red
            )


            Box(modifier = Modifier
                .constrainAs(textDes) {
                    top.linkTo(textTitle.bottom, margin = 15.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)

                }) {
                Column() {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, top = 10.dp),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Start,
                        text = stringResource(id = R.string.description)
                    )

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, top = 10.dp, end = 25.dp),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Start,
                        text = showToDoViewModel.todoModelState.description ?: ""
                    )
                }
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(textData) {
                        bottom.linkTo(parent.bottom, margin = 20.dp)
                        end.linkTo(parent.end, margin = 10.dp)
                    },
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                text = showToDoViewModel.todoModelState.date ?: ""
            )
        }
    }
}
