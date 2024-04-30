package presentation.screen.navigation.article.componet

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import data.source.model.ArticleModel
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ArticleItems(data:ArticleModel){

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .clickable {  }
    ) {

        val painterResource = asyncPainterResource(data.urlToImage) {

            // CoroutineContext to be used while loading the image.
            coroutineContext = Job() + Dispatchers.IO

            // Customizes HTTP request
        }

        KamelImage(
            resource = painterResource,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            onLoading = { progress -> CircularProgressIndicator(progress) },
            onFailure = {
                painterResource("user.xml")
            }
        )

        Column(modifier = Modifier.padding(top = 8.dp)) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = data.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Add more text composable for other article details as needed
        }
    }

}