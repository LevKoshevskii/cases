```
University: [ITMO University](https://itmo.ru/ru/)
Faculty: [FICT](https://fict.itmo.ru)
Course: Application containerization and orchestration
Year: 2023
Module: Internet of Things
Authors: German Ilya Andreevich (k4110c), Koshevsky Lev Sergeevich (k4113c)
Date of create: 15.06.2023
Date of finished: 30.06.2023
```
## Ход работы
Создаём образ нашей программы при помощиdocker build . -t cases`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/34d05be3-05d7-4353-b34d-dcd370f67108)
Проверяем список контейнеров командой `docker ps`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/8e31791c-815b-47e7-af99-3873f44e6499)
`docker login`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/42eabd26-80ad-47f5-ad87-385fc1d2ec58)
Пушим образ в докерхаб `docker push 2651915/cases:latest`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/b2f9eceb-6afd-4337-b422-ab4f4817f03d)
Проверяем наличие образа в DockerHub
![image](https://github.com/LevKoshevskii/cases/assets/116584865/e0e427a4-0689-4207-99a3-764342e7288d)
Запускаем миникуб командой `minikube start`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/ac53e5e9-bb19-4e7a-b004-950b6f775209)
Создаём неймспейс при помощи `kubectl create namespace cases` 
![image](https://github.com/LevKoshevskii/cases/assets/116584865/b5d9f58f-d7cb-4693-8862-cd35d2b76505)
Создаём деплоймент и помещаем его в созданный ранее неймспейс командой `kubectl apply -f deployment.yaml -n cases`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/2b90edc1-974f-485f-afa5-2332352b2cc4)
Создаём сервис командой `kubectl apply -f service.yaml -n cases`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/5de37f62-2026-4489-bf3b-c376c8d11e36)
Проверяем 
![image](https://github.com/LevKoshevskii/cases/assets/116584865/28adb853-4434-4959-a9b8-9a68a4ad5b3e)
![image](https://github.com/LevKoshevskii/cases/assets/116584865/e0bcf2ca-2636-49dc-82bb-dbf8bd1ece81)
Запускаем туннелирование при помощи `minikube tunnel`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/c01a4967-aa86-4b59-bbcf-e80584bca8ad)
Проверяем работу программы: разбиваем по падежам слово "Контернеризация"
![image](https://github.com/LevKoshevskii/cases/assets/116584865/71e22daf-d38d-408b-bf89-361cb6156f2f)










2. 
3. 
