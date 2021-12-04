import requests
import os
from bs4 import BeautifulSoup
from .config import sessionToken


def get_input(day, raw=False):
    cache_file_path = os.path.abspath(__file__ + f'/../_cache/{day}_input.txt')
    if os.path.exists(cache_file_path):
        with open(cache_file_path, mode='r') as f:
            input_text = f.read()
            f.close()
    else:
        response = requests.get(f'https://adventofcode.com/2021/day/{day}/input', headers={
            'cookie': f'session={sessionToken}',
        })

        input_text = response.text

        if response.text.startswith("Please"):
            raise Exception(input_text)

        with open(cache_file_path, mode='w') as f:
            f.write(input_text)
            f.close()

    if raw:
        return input_text
    else:
        return input_text.split("\n")[:-1]


def get_sample(day, raw=False):
    cache_file_path = os.path.abspath(__file__ + f'/../_cache/{day}_sample.txt')
    if os.path.exists(cache_file_path):
        with open(cache_file_path, mode='r') as f:
            input_text = f.read()
            f.close()
    else:
        response = requests.get(f'https://adventofcode.com/2021/day/{day}')

        parsed_html = BeautifulSoup(response.text, "lxml")
        elements = parsed_html.body.findAll('code')
        codeStrings = list(map(lambda o: o.text, elements))

        if len(codeStrings) == 0:
            raise Exception(response)

        input_text = max(codeStrings, key=len)
        with open(cache_file_path, mode='w') as f:
            f.write(input_text)
            f.close()

    if raw:
        return input_text
    else:
        return input_text.split("\n")[:-1]