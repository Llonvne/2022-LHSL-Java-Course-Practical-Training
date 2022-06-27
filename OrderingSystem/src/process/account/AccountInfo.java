package process.account;

import exec.Exec;
import exec.recall.Recevier;

public record AccountInfo(String account, String type, Recevier<Exec> sender) {
}
