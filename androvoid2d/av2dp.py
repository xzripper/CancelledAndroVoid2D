# av2dp.py - Part of Void2D.

from sys import argv

from pathlib import Path

from configparser import ConfigParser


args = argv[1:]

try: args[0]
except IndexError:
    print('ERROR: Missing project src name.')

    exit(1)

PROJECT_INI = f'{args[0]}\\androvoid2d\\project.ini'

cfg_parser = ConfigParser()

cfg_parser.read(f'{Path(PROJECT_INI).resolve()}')

try:
    field = args[1].upper()

    print(f'{field}: ({cfg_parser["AndroVoid2D"][field]}).')
except IndexError:
    print('ERROR: Missing field.')

except KeyError:
    print('ERROR: Unknown field.')
