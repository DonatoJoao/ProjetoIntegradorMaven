# Projeto Integrador I - Univesp
###  A Proposta do nosso projeto é...
***
<div align="center">
 <img src= "C:\Users\igmf5\Documents\GitHub\UNIVESP\barbearia.jpg" alt="capa github" 
  width="450"/>
</div>



***
 
## Introdução 

Desenvolver uma aplicação web utilizando linguagem de programação JAVA, um framework, banco de dados e controle de versionamento com GitHub.



****

## Objetivo

Desenvolver um sistema para: gerar controle de colaboradores, cadastro de clientes, planos de assinaturas e agendamentos.
***

## Arquitetura

![arquitetura](C:\Users\igmf5\Documents\GitHub\UNIVESP\arquitetura.jpg)

***
## Funcionamento 

...

Deverá seguir esses passso: 

1. Criando as classes

```bash
 {
    "files.autoSave": "afterDelay",
    "editor.fontSize": 24,
    "window.commandCenter": true,
    "workbench.statusBar.visible": false,
    "[python]": {
        "editor.formatOnType": true
    },
    "liveServer.settings.donotShowInfoMsg": true,
    "liveServer.settings.donotVerifyTags": true,
    "yaml.customTags": [
        "!And",
        "!And sequence",
        "!If",
        "!If sequence",
        "!Not",
        "!Not sequence",
        "!Equals",
        "!Equals sequence",
        "!Or",
        "!Or sequence",
        "!FindInMap",
        "!FindInMap sequence",
        "!Base64",
        "!Join",
        "!Join sequence",
        "!Cidr",
        "!Ref",
        "!Sub",
        "!Sub sequence",
        "!GetAtt",
        "!GetAZs",
        "!ImportValue",
        "!ImportValue sequence",
        "!Select",
        "!Select sequence",
        "!Split",
        "!Split sequence"
    ],
    "bracket-pair-colorizer-2.depreciation-notice": false,
    "git.openRepositoryInParentFolders": "never",
    "editor.codeActionsOnSave": {
        "source.organizeImports": "explicit"
    },
    "editor.linkedEditing": true,
    "editor.minimap.enabled": false,
    "editor.rulers": [
        {
            "column": 80,
            "color": "#00FF0010"
        },
        {
            "column": 100,
            "color": "#BDB76B15"
        },
        {
            "column": 120,
            "color": "#FA807219"
        }
    ],
    "editor.unicodeHighlight.includeComments": true,
    "emmet.variables": {
        "lang": "pt"
    },
    "workbench.colorCustomizations": {
        "[Default Dark Modern]": {
            "tab.activeBorderTop": "#00FF00",
            "tab.unfocusedActiveBorderTop": "#00FF0088",
            "textCodeBlock.background": "#00000055"
        },
        "editor.wordHighlightStrongBorder": "#FF6347",
        "editor.wordHighlightBorder": "#FFD700",
        "editor.selectionHighlightBorder": "#A9A9A9"
    },
    "workbench.editor.revealIfOpen": true,
    "workbench.tree.indent": 20,
    "files.eol": "\n",
    "[bat]": {
        "files.eol": "\r\n"
    },
    "cSpell.diagnosticLevel": "Hint",
    "trailing-spaces.backgroundColor": "rgba(255,0,0,0.1)",
    "trailing-spaces.includeEmptyLines": false,
    "terminal.integrated.tabs.hideCondition": "never",
    "terminal.integrated.enablePersistentSessions": false,
    "java.debug.settings.hotCodeReplace": "auto",
    "java.sources.organizeImports.staticStarThreshold": 1,
    "java.configuration.detectJdksAtStart": false,
    "java.configuration.updateBuildConfiguration": "automatic",
    "java.test.config": {
        "vmArgs": [
            "-Dstdout.encoding=UTF-8",
            "-Dstderr.encoding=UTF-8"
        ]
    },
    "maven.executable.path": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\maven\\latest\\bin\\mvn",
    "java.import.gradle.home": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\gradle\\latest",
    "java.configuration.runtimes": [
        {
            "name": "JavaSE-1.8",
            "path": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\8"
        },
        {
            "name": "JavaSE-11",
            "path": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\11"
        },
        {
            "name": "JavaSE-17",
            "path": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\17"
        },
        {
            "name": "JavaSE-21",
            "path": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\21",
            "default": true
        }
    ],
    "terminal.integrated.profiles.windows": {
        "JavaSE-1.8": {
            "overrideName": true,
            "env": {
                "PATH": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\8\\bin;${env:PATH}",
                "JAVA_HOME": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\8"
            },
            "path": "cmd"
        },
        "JavaSE-11": {
            "overrideName": true,
            "env": {
                "PATH": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\11\\bin;${env:PATH}",
                "JAVA_HOME": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\11"
            },
            "path": "cmd"
        },
        "JavaSE-17": {
            "overrideName": true,
            "env": {
                "PATH": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\17\\bin;${env:PATH}",
                "JAVA_HOME": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\17"
            },
            "path": "cmd"
        },
        "JavaSE-21": {
            "overrideName": true,
            "env": {
                "PATH": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\21\\bin;${env:PATH}",
                "JAVA_TOOL_OPTIONS": "-Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8",
                "JAVA_HOME": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\21"
            },
            "path": "cmd",
            "args": [
                "/k",
                "chcp",
                "65001"
            ]
        }
    },
    "terminal.integrated.defaultProfile.windows": "JavaSE-21",
    "terminal.integrated.automationProfile.windows": {
        "path": "cmd"
    },
    "terminal.integrated.env.windows": {
        "JAVA_HOME": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\21",
        "PATH": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\21\\bin;${env:PATH}"
    },
    "maven.terminal.customEnv": [
        {
            "environmentVariable": "JAVA_HOME",
            "value": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\21"
        }
    ],
    "java.import.gradle.java.home": "C:\\Users\\igmf5\\AppData\\Roaming\\Code\\User\\globalStorage\\pleiades.java-extension-pack-jdk\\java\\21",
    "tabnine.experimentalAutoImports": true,
    "git.autofetch": true
} 
```

...

...

```bash

```

...

2. ...

...
3. ...

...

****
## Organização

Para realização do Projeto, o grupo se reunião, através do whatsApp, para levantar algumas ideias de projetos, dentre elas: desenvolvimento de um sistema de precificação e controle de estoque para comércios; desenvolver uma rede de prestadores de serviços de uma determinada região para que usuários cadastrados possam entrar em contato e contratar serviços de profissionais registrados na plataforma; e desenvolver um sistema para uma barbearia onde os clientes podem fazer assinaturas de planos, fazer agendamentos e o proprietário tenha mais controle de seus colaboradores e ter um mural de patrocinadores. Depois de discutido entre os participantes do grupo, foi escolhida a última ideia de projeto. 

*** 

## Dificuldades Conhecidas

Como trazer inovação tecnológica a fim de modernizar a gestão, controle e ideias de negócio para este empreendimento. 



***
## Desenvolvedores do projeto

| [<img src="https://avatars.githubusercontent.com/u/170149114?v=4" width=115><br><sub>Bruna Tokuno de Sousa</sub>](https://github.com/bru-tokuno) | [<img src="https://avatars.githubusercontent.com/u/51243178?v=4" width=115><br><sub>Gabriel Santos Silva</sub>](https://github.com/GabrielSantos10) | [<img src="https://avatars.githubusercontent.com/u/124359272?v=4" width=115><br><sub>Irati Gonçalves Maffra</sub>](https://github.com/IratiMaffra) | [<img src="https://avatars.githubusercontent.com/u/163658340?v=4" width=115><br><sub>Jediael da Silva Ferreira</sub>](https://github.com/Jedi-Ferreira) | [<img src="https://avatars.githubusercontent.com/u/83663822?v=4" width=115><br><sub>João Donato de Morais Pereira</sub>](https://github.com/DonatoJoao) | [<img src="" width=115><br><sub>Lays Motta de Albuquerque Lourenço</sub>](https://github.com/Lays) | [<img src="" width=115><br><sub>Sandro Roberto Alves Júnior</sub>](https://github.com/sandro) | [<img src="https://media.licdn.com/dms/image/D4D03AQHigoFkbveHVA/profile-displayphoto-shrink_400_400/0/1701190953083?e=1721260800&v=beta&t=2i4rKOqXNAIQ9G01f1y5JeCWxbh61dSu1i1Rj7fNeTE" width=115><br><sub>Thiago Lourenço Sales</sub>](https://www.linkedin.com/in/thiago-louren%C3%A7o-b166041b1?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=ios_app) |
| :---: | :---: | :---: | :---: | :---: | :---: |:---: | :---: |

