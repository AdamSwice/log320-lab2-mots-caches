import sys
import re
import time
import os
import fnmatch
from threading import Thread
import time

import subprocess
import platform


def test(jarFile,gridFN,dictFN,expectedResults,tempsDemo):
    try:
        t1_labo = time.time()
        procResult = subprocess.run(["java","-jar",jarFile,gridFN,dictFN],stdout=subprocess.PIPE,stderr=subprocess.DEVNULL,timeout=120)
        #procResult = subprocess.run(["./MotsCaches",gridFN,dictFN],stdout=subprocess.PIPE,stderr=subprocess.DEVNULL,timeout=10)
        t2_labo = time.time()

        elapsedTime = t2_labo - t1_labo
        if platform.system() == "Windows":
            output = str(procResult.stdout,'utf-8').split('\r\n')[0:-3]
        else:   
            output = str(procResult.stdout,'utf-8').split('\n')[0:-3]

        #print(output)

        if expectedResults == output:
            tempsScore=0
            if elapsedTime < tempsDemo:
                tempsScore = 0.25

            return (1,tempsScore,elapsedTime)

        if len(output) == 0 or abs(len(output)-len(expectedResults)) > 1:
            return (0,0,3600)


        if len(output)<len(expectedResults):
            missingWords = []
            index = 0
            for w in expectedResults:
                if w == output[index]:
                    index = index +1
                    continue
                missingWords.append(w)

            if len(missingWords) < 2:
                return (0.5,0,3600)
            else:
                return (0,0,3600)

        return (0,0,3600)

    except subprocess.TimeoutExpired:
        return (0,0,3600)
   
if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Utilisation: python test.py jarFile")
        sys.exit(1)

    jarFile = sys.argv[1]


    r = re.compile('labo2-equipe[0-9][0-9].jar')
    if r.match(jarFile) is None:
        print("ATTENTION: Le nom du fichier .jar doit avoir ce format: labo1-equipeXX.jar")
        print("           où XX est le numéro de votre équipe")
    
    print("jarFile,res_demo,res_temp_demo,res_test1,res_temps_test1,res_test2,res_temps_test2,res_test3,res_temps_test2,points_total,totaltemps_total")
    tempsTotal = 0
        #print("{},".format(f),end="")
    (scoreT1,scoreTimeT1,timeT1) = test(jarFile,"grid_demo.txt","dict_demo.txt",["cas","casser","impot","lot","mot","noue","pain","pelle","pere","pere","piloter","pin","pinot","pinotte","plat","pli","pluie","pluriels","poli","polies","polo","pool","reel","role","super","tertre","tien","tilt","tomme","toute","uni","unir"],0.2)
    (scoreT2,scoreTimeT2,timeT2) = (0,0,0)
    (scoreT3,scoreTimeT3,timeT3) = (0,0,0)
    (scoreT4,scoreTimeT4,timeT4) = (0,0,0)
    scoreTotal = scoreT1+scoreTimeT1+scoreT2+scoreTimeT2+scoreT3+scoreTimeT3+scoreT4+scoreTimeT4
    totalTime = timeT1 + timeT2 + timeT3 + timeT4
    print("{},{},{},{},{},{},{},{},{},{},{}".format(jarFile,scoreT1,scoreTimeT1,scoreT2,scoreTimeT2,scoreT3,scoreTimeT3,scoreT4,scoreTimeT4,scoreTotal,totalTime))
    #sys.exit(0)
