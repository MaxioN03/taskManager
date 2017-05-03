package com.bsuir.service.enumeration;


import com.bsuir.service.command.*;
import com.bsuir.service.implement.ActionCommand;

/**
 * Created by Егор on 21.04.17.
 */
public enum CommandEnum {
    CSV {
        {
            this.command = new CSVCommand();
        }
    },
    ПРОСМОТРЕТЬ {
        {
            this.command = new ShowReportCommand();
        }
    },
    ПОИСК {
        {
            this.command = new SearchCommand();
        }
    },
    ДОБАВИТЬ {
        {
            this.command = new AddCommand();
        }
    },
    XML {
        {
            this.command = new XMLCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
