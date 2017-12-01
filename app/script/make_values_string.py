# _*_ coding: utf-8 _*_
import gspread
from oauth2client.service_account import ServiceAccountCredentials

import os

# XML 만들기
import xml.etree.cElementTree as ET


import sys
# reload(sys)
# sys.setdefaultencoding('utf-8')


DEFINE_KEY_COL = 4

def makeStringResources():

    # 파일 저장할 폴더 경로
    VALUES_PATH = sys.argv[1]
    JSON_KEY_PATH = sys.argv[2]

    scope = ['https://spreadsheets.google.com/feeds']
    creds = ServiceAccountCredentials.from_json_keyfile_name(JSON_KEY_PATH, scope)

    # oauth 인증
    client = gspread.authorize(creds)

    # AndroidFilter 시트 가져오기
    sheet = client.open("AndroidFilter").sheet1

    cells = sheet._fetch_cells()

    names = sheet.col_values(DEFINE_KEY_COL)
    # print(names)

    # 언어별로 xml 준비
    krXml = ET.Element("resources")
    enXml = ET.Element("resources")
    zhXml = ET.Element("resources")

    for cell in cells:

        cellRow = cell.row -1

        if(cell.col == 1):
            # XML sub element 추가
            ET.SubElement(krXml, "string", name=names[cellRow]).text = cell.value

        elif(cell.col == 2):
            # XML sub element 추가
            ET.SubElement(enXml, "string", name=names[cellRow]).text = cell.value

        elif(cell.col == 3):
            # XML sub element 추가
            ET.SubElement(zhXml, "string", name=names[cellRow]).text = cell.value

    KR_PATH = os.path.join(VALUES_PATH, "values-ko")
    EN_PATH = os.path.join(VALUES_PATH, "values")
    ZH_PATH = os.path.join(VALUES_PATH, "values-zh")

    # 폴더가 없으면 만들어준다
    if not os.path.exists(VALUES_PATH):
        os.makedirs(VALUES_PATH)

    if not os.path.exists(KR_PATH):
        os.makedirs(KR_PATH)

    if not os.path.exists(EN_PATH):
        os.makedirs(EN_PATH)

    if not os.path.exists(ZH_PATH):
        os.makedirs(ZH_PATH)

    krTree = ET.ElementTree(krXml)
    krTree.write(os.path.join(KR_PATH, "strings.xml"), encoding='utf-8', xml_declaration=True)

    enTree = ET.ElementTree(enXml)
    enTree.write(os.path.join(EN_PATH, "strings.xml"), encoding='utf-8', xml_declaration=True)

    zhTree = ET.ElementTree(zhXml)
    zhTree.write(os.path.join(ZH_PATH, "strings.xml"), encoding='utf-8', xml_declaration=True)

if __name__=='__main__': makeStringResources()
