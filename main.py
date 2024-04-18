import random

# Sample job data: job_id: processing_time
jobs = {
    'Job1': 4,
    'Job2': 7,
    'Job3': 2,
    'Job4': 5,
    'Job5': 1,
}

# Initial Population Size and Number of Generations
POP_SIZE = 5
N_GENERATIONS = 100

# Crossover and Mutation Rates
CROSSOVER_RATE = 0.8
MUTATION_RATE = 0.1

# Fitness Function: Sum of processing times (to be minimized)
def calculate_fitness(schedule):
    return sum(jobs[job_id] for job_id in schedule)

# Generate Initial Population: List of random schedules
def generate_initial_population():
    population = []
    for _ in range(POP_SIZE):
        schedule = list(jobs.keys())
        random.shuffle(schedule)
        population.append(schedule)
    return population

# Selection: Tournament Selection
def tournament_selection(population, k=3):
    selected = random.sample(population, k)
    selected.sort(key=calculate_fitness)
    return selected[0]

# Crossover: Single Point Crossover
def crossover(parent1, parent2):
    if random.random() < CROSSOVER_RATE:
        point = random.randint(1, len(parent1) - 1)
        child1 = parent1[:point] + parent2[point:]
        child2 = parent2[:point] + parent1[point:]
        return child1, child2
    return parent1, parent2

# Mutation: Swap Mutation
def mutate(schedule):
    if random.random() < MUTATION_RATE:
        i, j = random.sample(range(len(schedule)), 2)
        schedule[i], schedule[j] = schedule[j], schedule[i]
    return schedule

# Main GA Loop
def genetic_algorithm():
    population = generate_initial_population()
    for generation in range(N_GENERATIONS):
        new_population = []
        while len(new_population) < POP_SIZE:
            parent1 = tournament_selection(population)
            parent2 = tournament_selection(population)
            child1, child2 = crossover(parent1, parent2)
            new_population.append(mutate(child1))
            if len(new_population) < POP_SIZE:
                new_population.append(mutate(child2))
        population = new_population
        best_schedule = min(population, key=calculate_fitness)
        print(f"Generation {generation+1}: Best Schedule: {best_schedule} with Total Time: {calculate_fitness(best_schedule)}")
    return best_schedule

# Run the GA
best_schedule = genetic_algorithm()
print(f"\nOptimal Schedule: {best_schedule} with Total Time: {calculate_fitness(best_schedule)}")