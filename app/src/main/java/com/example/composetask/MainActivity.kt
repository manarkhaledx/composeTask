package com.example.composetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetask.ui.theme.ComposeTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTaskTheme {
                IssuesScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IssuesScreen() {
    val issues = listOf(
        Issue("a", "NONE", "2024-12-9, 1 PM", "Open"),
        Issue("b", "NONE", "2024-12-9, 1 PM", "Open"),
        Issue("c", "NONE", "2024-12-9, 1 PM", "Open"),
        Issue("d", "NONE", "2024-12-9, 1 PM", "Open"),
        Issue("e", "NONE", "2024-12-9, 1 PM", "Open"),
        Issue("f", "NONE", "2024-12-9, 1 AM", "Open"),
        Issue("g", "NONE", "2024-12-9, 1 AM", "Open"),
        Issue("h", "NONE", "2024-12-9, 1 AM", "Open"),
        Issue("i", "NONE", "2024-12-9, 1 AM", "Open"),
        Issue("j", "NONE", "2024-12-9, 1 AM", "Open"),
        Issue("k", "NONE", "2024-12-9, 1 AM", "Open"),
        Issue("l", "NONE", "2024-12-9, 1 AM", "Open"),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Issues") }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(issues) { issue ->
                IssueCard(issue)
            }
        }
    }
}

@Composable
fun IssueCard(issue: Issue) {
Card(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp),
    shape = RoundedCornerShape(8.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Issue Icon",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = issue.title,
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 1,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = issue.subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = issue.createdAt,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = issue.status,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IssuesScreenPreview() {
    ComposeTaskTheme {
        IssuesScreen()
    }
}
