import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DietPlanScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Daily Nutrition", style = MaterialTheme.typography.headlineMedium) }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item { DietPlanProgress() }
            item { DietPlanDetails() }
        }
    }
}

/**
 * Displays the current progress toward daily nutritional goals.
 */
@Composable
fun DietPlanProgress() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Daily Calories", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            // Linear Progress Indicator representing calorie intake
            LinearProgressIndicator(
                progress = { 0.65f },
                modifier = Modifier.fillMaxWidth().height(8.dp),
                strokeCap = ProgressIndicatorDefaults.LinearStrokeCap
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("1,300 kcal consumed", style = MaterialTheme.typography.bodySmall)
                Text("700 kcal left", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

/**
 * Displays the details of the diet plan, such as macros and meal logs.
 */
@Composable
fun DietPlanDetails() {
    Column {
        Text("Macronutrients", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MacroChip("Protein", "90g", 0.8f, Modifier.weight(1f))
            MacroChip("Carbs", "150g", 0.5f, Modifier.weight(1f))
            MacroChip("Fats", "45g", 0.4f, Modifier.weight(1f))
        }
    }
}

@Composable
fun MacroChip(label: String, value: String, progress: Float, modifier: Modifier = Modifier) {
    OutlinedCard(modifier = modifier) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Text(label, style = MaterialTheme.typography.labelMedium)
            Text(value, style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(4.dp))
            CircularProgressIndicator(
                progress = { progress },
                strokeWidth = 4.dp,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}