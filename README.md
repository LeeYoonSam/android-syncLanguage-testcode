# androidTest-Kotlin

## 1. 구글 Drive, Sheet를 이용한 실시간 번역

### 사용툴

* Google Sheet, Google AppScript - 번역 입력 및 트리거 
    * 구글 Sheet에서 각 언어별 번역 본 및 언어에 대한 key값 입력
    * 구글 AppScript에 트리거를 걸어서 sheet가 변경될때마다 복사본 파일에 그대로 적용(복사본을 활용해서 리소스 동기화)

* Python - Sheet 분석 및 데이터 가공(lib - gspread: 구글시트사용 라이브러리, oauth2client: google oauth 라이브러리)
    * Google API Console에서 Drive, Sheet API를 활성화 시키고 서비스계정 활성화 후 jsonkey파일 발급받아 oauth 인증때 사용
    * gspread 를 통해서 번역 데이터를 읽어 온다.
    * 안드로이드에서 사용하는 언어 리소스 XML 형태로 데이터를 가공해서 폴더 및 strings.xml 파일 생성
    
* AndroidStudio - Gradle Task를 추가해서 빌드시 자동으로 리소스 파일 업데이트 진행
    * AndroidStudio에서 Python Community Edition Plugin을 받아서 설치해서 파이썬 사용할 준비를한다.
    * Gradle task를 추가시키고 commandLine을 통해서 파이썬 파일을 실행시키면 자동으로 리소스 폴더에 언어값이 추가된다.
    
    
* 개발 지연되었던 부분
    * 그래들에서 기본적으로 파이썬 2.7로 적용되어서 라이브러리들이 안먹혀서 commandLine 명령에 'python' 대신
    /Library/Frameworks/Python.framework/Versions/3.6/bin/python3 경로로 전체 경로를 입력해서 해결



## Android Test Support Library

### jUnit Test

### UI Test


---


## 참고사이트
* [안드로이드 공식 사이트](https://developer.android.com/studio/test/index.html?hl=ko)
* https://fernandocejas.com/2017/02/03/android-testing-with-kotlin/
* https://tosslab.github.io/android/2016/02/12/Android-and-automation.html
* [안드로이드에 테스트 도입하기](http://blog.dramancompany.com/2016/08/안드로이드에-테스트-도입하기/)
* [안드로이드 테스팅 정리](http://kimjihyok.info/2017/04/06/android-testing-정리/)
* [안드로이드 언어 리소스 자동화](http://tiii.tistory.com/22)