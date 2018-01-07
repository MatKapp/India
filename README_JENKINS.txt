1. Sciagnąć Jenkinsa wersje LTS ze strony:
        https://jenkins.io/download/
2. Rozpakować
3. W terminalu przejść do katalogu Jenkins i wpisać polecenie
        java -jar jenkins.war
4. Przejść pod adres
        http://localhost:8080
5. Zalogowć się i sciągnąć rekomendowane pluginy
6. Jenkins powinien się odpalić i trzeba jeszcze dodać wtyczke do Mavena. Wybieramy:
        Zarządzaj Jenkinsem -> Zarządzaj wtyczkami -> Dostępne
        W filtrze wrzucić "Maven Integration plugin"
        Wybrac opcje Zainstaluj bez ponownego uruchamiania
7. Wrócić do początkowego menu i wybrać "Nowy Projekt"
        Wpisać India w nazwę projektu i wybrać opcję Maven project
        OK
        W części Repozytorium kodu wybrać Git i podać URL: https://github.com/MatKapp/India
        Zapisz
8. Kliknąć Uruchom
9. Jeżeli zadanie zakonczylo się pomyślnie to sie ciesz!
