package com.krish.myapplication.presentation.screens.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.krish.myapplication.data.model.Note
import com.krish.myapplication.navigation.Screen

private val noteList = mutableListOf(
    Note(1,"Krish","Parekh","High"),
    Note(1,"Parth","Parekh is brother","Low"),
    Note(1,"Hiren","Parekh is father","Medium"),
    Note(1,"Binal","Parekh is mother","High"),
)

@Composable
fun HomeScreen(
    navController : NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Home")
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                onClick = { navController.navigate(Screen.Add.route) }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Note",
                    tint = Color.White
                )
            }
        }

    ) { paddingValues ->  
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            items(noteList){ note: Note ->
                NoteCard(note = note)
            }
        }
    }
}

@Composable
fun NoteCard(note : Note) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = note.title,
                    fontSize = 20.sp,
                )
                Canvas(modifier = Modifier.size(20.dp)){
                    drawCircle(
                        color = Color.Red,
                        radius = size.minDimension / 4
                    )
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = note.description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}