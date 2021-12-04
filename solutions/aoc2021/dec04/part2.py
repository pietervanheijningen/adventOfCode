import sys
import os
import re
from pprint import pprint

sys.path.append(os.path.abspath(__file__ + '../../../..'))
from aoc2021.aoc import *

input = get_input(4)

drawn_numbers = list(map(int, input[0].split(",")))

boards = {}
board_count = 0
winning_boards = []
for line in input[2:]:
    row = re.split('[ ]+', line.strip())

    if row == ['']:
        board_count += 1
        continue

    if board_count not in boards:
        boards[board_count] = []
    boards[board_count].append(list(map(int, row)))

def play_bingo():
    for drawn_number in drawn_numbers:
        for board_index in boards:
            # mark the drawn number
            for row_index, row in enumerate(boards[board_index]):
                for num_index, num in enumerate(row):
                    if drawn_number == num and num >= 0:
                        if num == 0:
                            # hack to make it work with 0
                            boards[board_index][row_index][num_index] = -1000
                        else:
                            boards[board_index][row_index][num_index] = -num

            # check if row win
            for row in boards[board_index]:
                if max(row) < 0:
                    calculate_score(board_index, drawn_number)

            # check if col win
            num_of_cols = len(boards[board_index][0])
            for col_num in range(num_of_cols):
                if is_winning_column(col_num, board_index):
                    calculate_score(board_index, last_number=drawn_number)

def is_winning_column(col_num, board_index):
    for row in boards[board_index]:
        if row[col_num] > 0:
            return False
    return True

def calculate_score(board_index, last_number):
    if board_index in winning_boards:
        return

    sum_unmarked = 0

    for row in boards[board_index]:
        for num in row:
            if num >= 0:
                sum_unmarked += num

    winning_boards.append(board_index)
    print(sum_unmarked * last_number)

play_bingo()