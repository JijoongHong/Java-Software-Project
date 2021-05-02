﻿**2021소프트웨어프로젝트**

**프로젝트 3 – 사진앨범 프로그램**



![](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.001.jpeg)

**중앙대학교**

**소프트웨어프로젝트 03 분반**

**20176963 홍지중**

**목 차**

**1. 프로그램 구조설계…………………………………………….…………….3**

**1) Photo Class………..……….…………..……….………..……….……..…………….………….3**

**2) Album Class………..……….…………..……….………..……….……..……........................4**

**2. Class 구현……………………………………….......................................6**

**1) Photo Class 필수 메소드….……….………..……….……..…………………………….....6**

**2) Photo Class 추가구현 메소드 ……..…..………..………............................................7**

**3) Album Class 필수 메소드….……….………..……….……..……………………………....7**

**4) Album Class 추가구현 메소드 ……..……………………………….………..……….....10**

**3. 실행결과………………………………………........................................12**

**1) Auto Test 결과….……….………..……….……..…………………………….....................12**

**2) 추가구현 메소드 실행결과……..………………………………………………..……….....12**

**4. 원본소스코드………………………………………..………………………14**

**5. 자체평가표……………………………………………………………………20**

` `**TOC \o "1-3" \h \z \u 1. 프로그램 구조설계**

\1) Photo Class

- Photo Class는 앨범 속에 저장된 하나의 사진을 표현하는 객체이다. 그러므로 각 사진의 정보에 해당하는 데이터 필드가 필요하다. 
- 데이터 : 데이터는 문자열로 구성되며, 앨범추가시간을 기준으로 사진을 식별할 수 있는 식별자(id), 사진의 이름(photoName), 앨범에 추가된 시간(addTime), 사진의 분류(categoty), 파일명(imageFileName)으로 구성된다. 
- 생성자 : 클래스의 생성자는 data파일에서 데이터를 파싱 후, 일괄적으로 사진의 정보를 입력하게 되므로 위에 언급한 모든 자료들을 받는 생성자가 필요하다. 더불어 사진을 일괄적으로 앨범에 저장하지 않고, 개별적으로 저장하는 경우가 있을 수 있다. 이 때는 파일명만을 받아서 현재시간으로 앨범에 추가하는 생성자가 필요하다.

-> 설계 중 고민사항 : 파일이름만 받게되면, id와 addTime은 자동적으로 생성이 되지만 사진의 이름과 카테고리는 비어있게 된다. 그러므로 파일명과 함께 사진이름, 카테고리를 입력받아 현재시간으로 앨범에 추가하는 생성자도 추가적으로 설계하였다.

- 메소드 : 클래스의 메소드는 과제의 요구사항대로 호출 시 사진의 정보를 출력하는 메소드가 필요하다. 더불어 파일 이름만 받게 되면 추후 카테고리와 이름을 설정할 필요가 있고, 이미 일괄적으로 입력했다고 하더라도 수정이 필요한 경우가 있다. 이에 setCategory와 setPhotoName을 만들어 이를 수정할 수 있도록 했다. 이외의 데이터에 대해서는 수정되어서는 안 되므로 제작하지 않았다. 

-> 설계 중 고민사항 : setCategory와 setPhotoName를 Photo클래스와 Album클래스 중 어느곳에 선언할지 고민을 하였다. 초기에는 사진앨범의 경우 사진의 정보를 수정하는 기능을 가져야 한다는 의미를 고려하였을 때 Album에 선언하는 것이 옳다는 생각을 하였으나, Java의 캡슐화를 고려하였을 때 Photo의 각 데이터는 private으로 설정되어 임의로 변경이 불가능하도록 하여야 한다. 그러므로 Photo클래스 내에 선언하는 한편, 각 데이터를 리턴하는 getter 메소드를 설계하였다. 

- 이를 정리하면 다음과 같다.

|<p>**<Class name>**</p><p>Photo</p>|
| :- |
|<p>**<Data field>**</p><p>id: String</p><p>photoName: String</p><p>addTime: String</p><p>categoty: String</p><p>imageFileName: String</p>|
|<p>**<Constructors>**</p><p>Photo(id: String, photoName: String, addTime: LocalDateTime, categoty: String, imageFileName: String)</p><p>Photo(imageFileName : String)</p><p>Photo(imageFileName : String, PhotoName : String, category : String)</p><p></p><p>**<Methods>**</p><p>print( )</p><p>setCategory(categoty: String)</p><p>setPhotoName(PhotoName: String)</p><p>getId ( ): String</p><p>getPhotoName ( ): String</p><p>getAddTime ( ): String</p><p>getCategoty ( ): String</p><p>getImageFileName ( ): String</p>|










\2) Album Class

- Album 클래스는 사진 객체들을 통합적으로 관리하는 클래스이다. 
- 데이터 : 데이터는 사진 객체들을 여러개 관리하므로 Photo클래스로 이루어진 배열(Album)과 전체 사진 개수를 표현하는 numOfPhotos로 구성된다.
- 생성자 : 생성자는 초기에 통합적으로 데이터를 입력받아 이를 파싱 후 저장하므로 사진정보들을 인자로 받는 생성자로 구성된다.
- 메소드
  - private void getData(String photoInfoFileName) : 사진정보파일을 기반으로 이를 라인별로 분리해주는 역할을 수행해준다. 만약 "//"이나 빈칸이라면 이를 주석처리하여 처리하지 않고, 그렇지 않다면 각 줄의 정보를 파싱하는 getPhotoInfo를 호출한다. 더불어 존재하지 않는 파일을 인자로 받았을 경우 오류를 발생시키는 역할을 한다.
  - private void getPhotoInfo(String line) : 주석이 아닌 라인을 입력받아 각 정보를 파싱하고 Photo객체를 생성한다. 이 때 유효성 검사를 수행하여 올바른 날짜 양식인지, 파일명이 존재하는지, 이미 동일한 id를 가진 Photo 인스턴스가 있는지 확인한다. 이 과정은 private boolean fileNameValidator(String imageFileName), private boolean idConflictValidator(String id)를 호출함으로써 이루어진다.

-> 설계 중 고민사항 : 구현 중 날짜 유효성 검사 시 날짜는 String형의 파싱 정보를 LocalDateTime형으로 다시 파싱하였다. 이에 dateFormatValidater를 운용한다면 boolean 형식으로 값을 반환할 때 LocalDateTime형으로 파싱하는 작업을 중복수행하여야하고, LocalDateTime형을 반환한다면 참거짓 유무를 알기 어려웠다. 그러므로 검증 과정을 getPhotoInfo 내에서 수행하였다.

- public int numPhotos() : 앨범 클래스 내의 사진의 갯수는 private으로 선언하여 외부의 임의 변경을 막아야 한다. 그러므로 사진의 갯수를 반환하는 메소드가 필요하다.
- public Photo getPhoto(int i) : 앨범 배열 내의 사진 인스턴스들은 외부의 임의 변경이 불가능한 private 변수들이다. 그러므로 사진 인스턴스를 반환하는 메소드가 필요하다.
- public void addPhotoByFileName(String line) : 일괄적으로 사진을 추가하는 것이 아니라, 이미 구성된 앨범에 사진을 개별적으로 추가할 경우에 사진이름을 통해 Photo 인스턴스를 생성한다.
- public void addPhoto(String line) : 사진이름으로만 Photo 인스턴스를 생성하게 된다면 카테고리와 사진 이름이 지정이 되지 않는다. 이에 카테고리와 사진이름을 함께 인자로 전달하여 Photo 인스턴스를 생성하도록 한다.
- public void delPhoto(int i) : 앨범 객체 내에서 Photo 인스턴스를 삭제한다.
- public void sortById() : 앨범 객체 내에서 Photo 인스턴스를 추가순서대로 정렬한다. 

-> 설계 중 고민사항 : 초기에 앨범 객체를 생성할 때에는 추가순서대로 저장이 되지만, 다른 방식으로 정렬 후 원상복구 시에 필요한 메소드이다. 

- public void sortByCategory( ) : 앨범 객체 내에서 Photo 인스턴스를 카테고리 순서대로 정렬한다.
- public void sortByPhotoName( ) : 앨범 객체 내에서 Photo 인스턴스를 사진이름 순서대로 정렬한다.
- public void exportToTxt(String path) : 앨범 객체 내에 저장된 Photo 인스턴스를 txt파일로 지정된 경로에 저장한다. 
- 이를 정리하면 다음과 같다.

|<p>**<Class name>**</p><p>Album</p>|
| :- |
|<p>**<Data field>**</p><p>numOfPhotos: int</p><p>Album: Photo[ ]</p>|
|<p>**<Constructor>**</p><p>Album(photoFileName: String)</p><p></p><p>**<Methods>**</p><p>getData(photoFileName : String)</p><p>getPhotoInfo(line: String) </p><p>fileNameValidator(imageFileName: String) : boolean</p><p>idConflictValidator(id: String) : boolean</p><p>numPhotos( ) : int</p><p>getPhoto(i: int) : Photo</p><p>addPhotoByFileName(line: String)</p><p>addPhoto(line: String)</p><p>delPhoto(i: int)</p><p>sortById( )</p><p>sortByCategory( )</p><p>sortByPhotoName( )</p><p>exportToTxt(path: String)</p>|








**2. Class 구현**

\1) Photo Class 필수 메소드

- 변수 : Photo Class의 변수들은 private으로 선언되어 임의로 변경되지 못하도록 하였다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.002.png)

- 생성자 : 사진들의 각 정보를 받아서 각 변수에 저장한다. LocalDateTime으로 파싱된 addTime을 포맷대로 String화 하여 저장한다. this를 활용하여 인자와 변수를 구분한다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.003.png)

- Photo(imageFileName : String) : image 파일 이름을 받아 현재시간으로 앨범 추가시간 및 ID를 생성한다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.004.png)

- Public void print( ) : 하나의 사진에 대한 정보를 콘솔로 출력한다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.005.png)

\2) Photo Class 추가구현 메소드

- Photo(String imageFileName, String PhotoName, String category) : 생성자를 오버로딩하여 image 파일이름과 함께 사진이름, 카테고리를 입력받아 사진 인스턴스를 생성한다. 

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.006.png)

- public void setCategory(String category), public void setPhotoName(String photoName) : image 파일만으로 인스턴스를 생성한 이후 사진이름과 카테고리를 설정할 수 있도록 한다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.007.png)

- public String get\_\_\_\_( ): 모든 클래스 내 변수에 대해 호출 시 해당 변수를 반환한다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.008.png)

\3) Album Class 필수 메소드

- Album Class의 변수들은 private으로 선언되어 임의로 변경되지 못하도록 하였다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.009.png)

- 생성자 Album(String photoInfoFileName): 사진정보 파일이름을 인자로 받아 기술된 사진 정보들로 사진 목록을 생성한다. 이 때 사진 인스턴스의 갯수는 100개로 제한된다. 더불어 사진정보파일로 사진 인스턴스를 생성하도록 하는 getData를 호출한다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.010.png)

- private void getData(String photoInfoFileName) : 사진정보파일을 인자로 받아 파일 객체를 생성하고, 스캐너 객체를 통해 이를 한줄씩 읽는다. 다만 이 때 // 혹은 공백인 경우 주석에 해당하므로 무시하고, 유효한 정보가 있는 줄을 인자로하여 getPhotoInfo를 호출한다. 이는 line 내의 정보를 파싱하고 사진 인스턴스를 생성할 수 있도록 한다. Try-catch 문을 활용하여 만약 사진정보파일이 존재하지 않으면 오류메시지를 출력한다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.011.png)

-> 구현 시 시행착오 : try외부에서 파일 클래스과 스캐너 클래스를 선언하였을 때 변수의 scope가 맞지 않아 오류가 발생하여 try문 내부에서 선언하였다. 또한 주석처리의 빈칸을 line.startWith(‘\n’)과 line.startWith(‘’)로 시도하였으나 오류가 발생하여 isEmpty로 변경하였다.

- private void getPhotoInfo(String line) 
- 사진정보파일 내 한 줄을 인자로 받아 split을 활용하여 각기의 정보로 분리한 후 저장하였다. 이 때 저장과 동시에 공백을 제거하였다. 
- 더불어 입력된 정보의 유효성을 검사하는 작업도 수행한다. Boolean 타입의 isCorrectDateFormat, isFileNameExist, isConflict 변수를 선언하여 유효 여부를 저장하였으며, 여러 오류가 있을 때 하나의 오류만 출력하도록 하였다. 
- 더불어 위 세 변수가 모두 true여야만 사진 인스턴스를 생성하도록 하여 오류가 있는 줄을 건너뛰도록 조치하였다. 
- 이 때 fileNameValidator와 idConflictValidator 메소드를 활용하여 유효성 검사를 수행하였다. 날짜의 경우 따로 메소드를 구현하지 않았는데, dateFormatValidater를 운용한다면 boolean 형식으로 값을 반환할 때 getPhotoInfo내에서 LocalDateTime형으로 파싱하는 작업을 중복수행하여야하고, LocalDateTime형을 반환한다면 참거짓 유무를 알기 어려웠다. 그러므로 검증 과정을 getPhotoInfo 내에서 수행하였다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.012.png)

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.013.png)

-> 구현 시 시행착오 : trim 메소드를 사용해 문자열 중간의 공백이 제거되지 않았다. 이에 replaceAll메소드를 활용하여 공백을 없애주었다. 그러나 전체 line에 대해 공백을 제거할 경우에 정보가 없는 token을 처리할 때 오류가 발생하여 각기 저장 시에 공백을 삭제하였다. 더불어 기존에는 fileNameValidator에서 문자열을 비교할 때 ==을 사용하였다. Java15버전에서는 이 부분이 정상 작동하였으나 Auto Test의 결과값이 상이하게 출력되어 문제점을 인지하고 equals로 변경하였다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.014.png)

- public int numPhotos() : 사진갯수는 임의로 변경되어서는 안 되는 변수이므로 private으로 선언하고, 위 메소드를 통하여 정보에 접근할 수 있도록 하였다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.015.png)

- public Photo getPhoto(int i): 앨범 객체 내의 사진 인스턴스로 구성된 배열은 임의로 변경되어서는 안 되므로 private으로 선언하고, 위 메소드를 통하여 정보에 접근할 수 있도록 하였다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.016.png)

-> 구현 시 시행착오 : 본인이 작성한 TestMain에서는 The album has N photos를 출력하기 위하여 사진정보 출력 전 numPhotos를 호출하는 코드를 작성하였다. 그러나 Auto Test에서는 해당 코드가 없는 것으로 추정되었고, 초기에는 numPhotos호출 시 위 구문을 출력하도록 하였다. 그러나 main에서 numPhotos만큼 반복하는 코드가 있고, i의 값을 반복 시마다 비교하기 위해 numPhotos를 호출하게 되어 구문이 중복출력되는 문제가 있었다. 이에 getPhoto메소드는 사진정보 출력시에만 사용된다는 점을 고려하여, 과제요구사항에 맞추고자 첫번째 사진정보를 반환할 때 사진의 갯수도 함께 출력하도록 하였다. 

\4) Album Class 추가구현 메소드

- public void addPhotoByFileName(String line) : image파일 이름을 받아 사진 인스턴스를 생성하고 이를 앨범에 저장하는 메소드이다. 입력 line의 형식에 맞추어 “;”를 기준으로 split한 토큰의 마지막인 image파일만을 파싱하도록 하였다. 추후 입력 방식이 바뀌거나 실제 파일을 선택하도록 할 때는 split없이 해당 파일의 gui에서 선택한 파일의 path를 기준으로 사진 인스턴스를 생성하도록 변경할 예정이다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.017.png)

- public void addPhoto(String line) : image파일로 사진 인스턴스를 추가할 때 사진이름과 카테고리를 함께 입력받아 사진 클래스의 모든 변수가 채워지도록 하는 메소드이다. 입력 line의 형식에 맞추어 “;”를 기준으로 split한 토큰의 해당 정보만을 파싱하도록 하였다. 추후 입력 방식이 바뀌거나 실제 파일을 선택하도록 할 때는 split없이 gui에서 해당 파일을 선택함과 동시에 이름과 카테고리를 입력받아 사진 인스턴스를 생성하도록 할 예정이다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.018.png)

- public void delPhoto(int i) : 원하는 위치의 사진 인스턴스를 삭제하는 기능이다. 이 때 Album배열과 같이 Photo 배열 100개를 선언하고, 지울 사진의 위치를 제외한 사진 인스턴스를 새로운 배열에 옮겼다. 이후 Album 배열이 새로운 배열을 가리키게 만듦으로써 garbage collector에 의해 기존 배열이 삭제되도록 하였다. 추후 ArrayList를 공부한 후 해당 기능을 변경할 예정이다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.019.png)

- public void exportToTxt(String path) : 메모리 상에 저장되어 있는 사진정보들을 저장하는 메소드이다. Filewriter와 Printwriter 객체를 활용하여 입력받은 path에 사진정보를 담은 txt파일을 생성한다. 이 때 사진 인스턴스에 대한 접근은 getter메소드를 통해 이루어진다. 

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.020.png)

- sort메소드 : Arrays.sort( )메소드를 통해 구현할 수 없었고, 클래스 내 특정 변수를 기준으로 정렬해야 하므로 어려움이 따랐다. 우선 method signature만 구현 해놓은 다음 추후 ArrayList와 Compartor를 학습한 후에 구현할 예정이다. 

**3. 실행결과**

\1) Auto Test 결과

- Auto Test 결과 예시정답과 동일하게 출력된 것을 알 수 있다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.021.png)

\2) 추가구현 메소드 실행결과

- 추가구현 메소드의 실행결과를 테스트하기 위하여 작성한 TestMain은 다음과 같다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.022.png)

기존 사진데이터로 앨범과 사진 인스턴스를 생성하고, path를 인자로 하여 사진 인스턴스를 추가로 생성하였다. 이후 해당 인스턴스에 대해 카테고리와 이름을 추가로 지정해주었다. 더불어 파일이름, 카테고리, 사진이름을 인자로 하여 사진을 추가하였다. 이후에 3번째 사진을 삭제하였고 이 결과를 txt파일로 저장하였다. 

- 콘솔 출력 결과 정상적으로 작동한 것을 볼 수 있다. 

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.023.png)

- txt 파일 역시 정상적으로 생성되었다.

![](Aspose.Words.21670a06-6fed-4675-af64-fa1ba09203a9.024.png)



**4. 원본 소스코드 – Photo Class**

|<p>import java.time.LocalDateTime;</p><p>import java.time.format.DateTimeFormatter;</p><p></p><p>public class Photo {</p><p></p><p>`	`private String id;</p><p>`	`private String photoName;</p><p>`	`private String addTime;</p><p>`	`private String category;</p><p>`	`private String imageFileName;</p><p>	</p><p>`	`Photo(String imageFileName){</p><p>`		`this.imageFileName = imageFileName;</p><p>`		`LocalDateTime now = LocalDateTime.now();</p><p>`		`DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd\_HH:mm:ss:SSS");</p><p>`		`this.addTime = now.format(formatter).toString();</p><p>`		`this.id = "IMG"+this.addTime;</p><p>`	`}</p><p>	</p><p>`	`Photo(String imageFileName, String photoName, String category){</p><p>`		`this.imageFileName = imageFileName;</p><p>`		`LocalDateTime now = LocalDateTime.now();</p><p>`		`DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd\_HH:mm:ss:SSS");</p><p>`		`this.addTime = now.format(formatter).toString();</p><p>`		`this.id = "IMG"+this.addTime;</p><p>`		`this.category = category;</p><p>`		`this.photoName = photoName;</p><p>`	`}</p><p>	</p><p>`	`Photo(String id, String photoName, LocalDateTime addTime, String category, String imageFileName){</p><p>`		`this.id = id;</p><p>`		`this.photoName = photoName;</p><p>`		`LocalDateTime time = addTime;</p><p>`		`DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd\_HH:mm:ss:SSS");</p><p>`		`this.addTime = time.format(formatter).toString();</p><p>`		`this.category = category;</p><p>`		`this.imageFileName = imageFileName;</p><p>`	`}</p><p>	</p><p></p><p>	</p><p>`	`public void print() {</p><p>`		`System.out.print(this.id+";"+this.photoName+";"+this.addTime+";"+</p><p>`						`this.category+";"+this.imageFileName+";\n");</p><p>`	`}</p><p>	</p><p>`	`//-----------추가 구현 사항-----------//</p><p>	</p><p>`	`public void setCategory(String category) {</p><p>`		`this.category = category;</p><p>`	`}</p><p>	</p><p>`	`public void setPhotoName(String photoName) {</p><p>`		`this.photoName = photoName;</p><p>`	`}</p><p>	</p><p>`	`public String getId() {</p><p>`		`return this.id;</p><p>`	`}</p><p>	</p><p>`	`public String getPhotoName() {</p><p>`		`return this.photoName;</p><p>`	`}</p><p>	</p><p>`	`public String getAddTime() {</p><p>`		`return this.addTime;</p><p>`	`}</p><p>	</p><p>`	`public String getCategory() {</p><p>`		`return this.category;</p><p>`	`}</p><p>	</p><p>`	`public String getImageFileName() {</p><p>`		`return this.imageFileName;</p><p>`	`}</p><p>	</p><p>}</p><p></p>|
| :- |



**4. 원본 소스코드 – Album Class**

|<p>import java.io.\*;</p><p>import java.time.LocalDateTime;</p><p>import java.time.format.DateTimeFormatter;</p><p>import java.time.format.DateTimeParseException;</p><p>import java.util.Scanner;</p><p></p><p>public class Album {</p><p></p><p>`	`private Photo[] Album;</p><p>`	`private int numOfPhotos;</p><p>	</p><p>`	`Album(String photoInfoFileName){</p><p>`		`this.Album = new Photo[100];</p><p>`		`this.numOfPhotos = 0;</p><p>`		`this.getData(photoInfoFileName);</p><p>`	`}</p><p>	</p><p>`	`private void getData(String photoInfoFileName) {</p><p>`		`try {</p><p>`			`File file = new File(photoInfoFileName);</p><p>`			`Scanner input = new Scanner(file);</p><p>`			`while (input.hasNext()) {</p><p>`				`String line = input.nextLine();</p><p>`				`if(line.startsWith("//") || line.isEmpty()) {</p><p>`					`continue;</p><p>`				`}else {</p><p>`					`getPhotoInfo(line);</p><p>`				`}</p><p>`			`}</p><p>`			`input.close();</p><p>`		`}</p><p>`		`catch(Exception e) {</p><p>`			`System.*out*.println("Unknown Album data File");</p><p>`		`} </p><p>`	`}</p><p></p><p></p><p></p><p></p><p></p><p>`	`private void getPhotoInfo(String line) {</p><p>`		`String[] tokens = line.split(";");</p><p>`		`String id = tokens[0].replaceAll(" ", "");</p><p>`		`String photoName = tokens[1].replaceAll(" ", "");</p><p>`		`boolean isCorrectDateFormat;</p><p>`		`LocalDateTime addTime = null;</p><p>`		`try {</p><p>`			`DateTimeFormatter formatter = </p><p>`                                   `DateTimeFormatter.*ofPattern*("yyyy-MM-dd\_HH:mm:ss:SSS");</p><p>`			`addTime = LocalDateTime.*parse*(tokens[2].replaceAll(" ", ""), formatter);</p><p>`			`isCorrectDateFormat = true;</p><p>`		`}catch (DateTimeParseException e) {</p><p>`			`isCorrectDateFormat = false;</p><p>`			`System.*out*.println("Wrong Date Format : Skip the input line : "+line);</p><p>			</p><p>`		`}</p><p>`		`String category = tokens[3].replaceAll(" ", "");</p><p>`		`String imageFileName = tokens[4].replaceAll(" ", "");</p><p>		</p><p>`		`boolean isFileNameExist = fileNameValidator(imageFileName);</p><p>`		`boolean isConflict = idConflictValidator(id);</p><p>`		`if (isFileNameExist == false && isCorrectDateFormat == true) {</p><p>`			`System.*out*.println("No Image File : Skip the input line : "+line);</p><p>`		`};</p><p>`		`if (isConflict == true && isFileNameExist == true) {</p><p>`			`System.*out*.println("ID Conflict (a photo with the same ID already exist) : </p><p>`                                             `Skip the input line : "+line);</p><p>`		`};</p><p>`		`if (isCorrectDateFormat == true && isFileNameExist == true && isConflict == false) {</p><p>`			`Album[this.numOfPhotos++] = new Photo(id, photoName,</p><p>`                                    `addTime, category, imageFileName);</p><p>`		`}</p><p>`	`}</p><p>	</p><p>`	`public int numPhotos() {</p><p>`		`return this.numOfPhotos;</p><p>`	`}</p><p>	</p><p>`	`public Photo getPhoto(int i) {</p><p>`		`if (i == 0)</p><p>`			`System.*out*.println("The album has "+this.numOfPhotos+" photos");</p><p>		</p><p>`		`return Album[i];</p><p>`	`}</p><p>	</p><p>`	`//-----------추가 구현 사항-----------//</p><p>	</p><p>`	`private boolean fileNameValidator(String imageFileName) {</p><p>`		`if(imageFileName.equals("")) {</p><p>`			`return false;</p><p>`		`}else return true;</p><p>		 </p><p>`	`}</p><p>	</p><p>`	`private boolean idConflictValidator(String id) {</p><p>`		`for(int i = 0; i<this.numOfPhotos; i++) {</p><p>`			`if(Album[i].getId().equals(id)) return true;</p><p>`		`}</p><p>`		`return false;</p><p>`	`}</p><p>	</p><p>`	`public void addPhotoByFileName(String line) {</p><p>`		`String[] tokens = line.split(";");</p><p>`		`String fileName = tokens[tokens.length-1];</p><p>`		`Album[this.numOfPhotos++] = new Photo(fileName);</p><p>`	`}</p><p>	</p><p>	</p><p>`	`public void addPhoto(String line) {</p><p>`		`String[] tokens = line.split(";");</p><p>`		`String fileName = tokens[tokens.length-1];</p><p>`		`String photoName = tokens[1].replaceAll(" ", "");</p><p>`		`String category = tokens[3].replaceAll(" ", "");</p><p>`		`Album[this.numOfPhotos++] = new Photo(fileName, photoName, category);</p><p>`	`}</p><p>	</p><p>`	`public void delPhoto(int i) {</p><p>`		`Photo[] temp = new Photo[100];</p><p>`		`int j=0,flag=0;</p><p>		</p><p>`		`while (j < numOfPhotos) {</p><p>`			`if (i == j) {</p><p>`				`j++;</p><p>`				`flag=1;</p><p>`			`}</p><p>`			`else if(flag==1){</p><p>`				`temp[j-1] = Album[j];</p><p>`				`j++;</p><p>				</p><p>`			`}else {</p><p>`				`temp[j] = Album[j];</p><p>`				`j++;</p><p>`			`}</p><p>`		`}</p><p>`		`numOfPhotos--;</p><p>`		`Album = temp;</p><p>`	`}</p><p>	</p><p>`	`public void exportToTxt(String path) throws IOException{</p><p>`		`FileWriter fileWriter = new FileWriter(path);</p><p>`		`PrintWriter printWriter = new PrintWriter(fileWriter);</p><p>`		`for(int i = 0; i < numOfPhotos; i++) {</p><p>			</p><p>`			`printWriter.print(Album[i].getId()+";"+Album[i].getPhotoName()+";"+Album[i].getAddTime()</p><p>`					`+";"+Album[i].getCategory()+";"+Album[i].getImageFileName()+";\n");</p><p>`		`}</p><p>`		`printWriter.close();</p><p>`	`}</p><p>	</p><p>	</p><p>`	`public void sortById() {</p><p>`		`//ArrayList와 Compartor 통해 추후 구현예정 </p><p>`	`}</p><p>	</p><p>`	`public void sortByCategory() {</p><p>`		`//ArrayList와 Compartor 통해 추후 구현예정 </p><p>`	`}</p><p>	</p><p>`	`public void sortByPhotoName() {</p><p>`		`//ArrayList와 Compartor 통해 추후 구현예정 </p><p>`	`}</p><p>	</p><p></p>|
| :- |



**5. 자체평가표** 

평 가 표

|평가 항목|<p>학생 자체 평가 </p><p>(리포트 해당 부분 표시 및 </p><p>간단한 의견)</p>|평가 (빈칸)|<p>점수</p><p>(빈칸)</p>|
| :-: | :-: | :-: | :-: |
|<p></p><p>기본 동작</p><p>-autotest 결과화면</p><p></p>|autotest 및 자체 추가 메소드에 대한 기본 동작 검증 결과 정상적으로 출력되었음 - 12p |||
|<p>설계 사항</p><p>- 설계 착안점</p><p>- 사용한 클래스 설명</p><p>- 시행착오 및 해결책</p>|<p></p><p>설계 착안점 : 클래스 별 구조설계 시 “설계 중 고민사항”을 추가하여 설명 – 3~6p</p><p></p><p>클래스 설명 : 6p부터 각 클래스 별 필수요소 및 자발적으로 추가한 요소들을 설명 – 6~11p</p><p></p><p>시행착오 및 해결책 : 클래스 설명 시 “구현 시 시행착오”를 추가하여 설명 – 6~11p</p><p></p>|||
|<p></p><p>본인 인증</p><p></p><p></p>|실행 결과에서 autotest의 학번, TestMain에서 새로 추가한 파일에 본인의 이름을 추가함으로써 인증 -12p|||
|기타|<p></p><p></p><p></p>|||
|총평/계|<p></p><p>설계와 구현, 실행결과를 나누어서 설명하였으며</p><p>필수 메소드와 추가설계 메소드를 분리하여 채점자의 편의성을 높히고자 노력하였음 </p><p></p>|||

` `PAGE 3
