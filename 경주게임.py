import random

class HorseRaceGame:
    def __init__(self, horses):
        self.horses = horses

    def race(self, num_steps=5):
        print("경주 시작!")
        for _ in range(num_steps):
            print("\n")
            for horse in self.horses:
                horse.move()
                horse.display()

        winner = max(self.horses, key=lambda x: x.position)
        print(f"\n{winner.name}이(가) 우승했습니다!")

class Horse:
    def __init__(self, name):
        self.name = name
        self.position = 0

    def move(self):
        self.position += random.randint(1, 3)

    def display(self):
        print(f"{self.name}: {'-' * self.position}>")

# 사용자가 말의 수 및 경주 단계를 선택할 수 있도록 합니다.
horse_count = int(input("경주에 참여할 말의 수를 입력하세요: "))
race_steps = int(input("경주할 단계 수를 입력하세요: "))
horses = [Horse(f"Horse {i + 1}") for i in range(horse_count)]

game = HorseRaceGame(horses)
game.race(num_steps=race_steps)