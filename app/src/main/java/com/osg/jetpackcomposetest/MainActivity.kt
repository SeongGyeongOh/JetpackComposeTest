package com.osg.jetpackcomposetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.osg.jetpackcomposetest.ui.JetpackComposeTestTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    newStory()
                }
            }
        }
    }
}

@Composable
fun newStory() {
    val image= imageResource(id = R.drawable.header)
    //머티리얼 디자인 적용하기
    MaterialTheme {
        val typography= MaterialTheme.typography

        //요소를 수직으로 쌓기 - Column
        Column(
        //매개변수로 전달되어 열에 스타일 추가 - modifier
                modifier = Modifier.padding(12.dp)
        ){
            //이미지에 적용할 속성들
            val imageModifier=Modifier
                    .preferredHeight(180.dp)
                    .fillMaxWidth()
                    .clip(shape= RoundedCornerShape(4.dp)) //머티리얼 디자인 적용 - 둥근 모서리

            //파라미터로 이미지 속성 전달
            Image(image, imageModifier, contentScale = ContentScale.Crop)
            Spacer(Modifier.preferredHeight(16.dp))

            Text("A day in Shark Fin Cove"+
                    "아무거나 길게 작성하기"+
                    "what about long sentence??"+
                    "리액트와 매우 비슷한 느낌을 받고 있음... 알고리즘만 아니면 매우 재미있다!",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis)
            Spacer(Modifier.preferredHeight(24.dp))
            Text("What a nice day!", style = typography.body2)
            Text("배고파.....", style = typography.body2)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    newStory()
}